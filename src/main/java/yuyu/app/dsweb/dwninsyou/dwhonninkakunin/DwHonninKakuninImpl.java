package yuyu.app.dsweb.dwninsyou.dwhonninkakunin;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.base.BaseUserInfo;
import yuyu.common.biz.bzcommon.BizDateUtil;
import yuyu.common.biz.bzcommon.RayConvertUtil;
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.direct.dscommon.DsSaibanSyori;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEdit;
import yuyu.common.direct.dscommon.DsTetudukiRirekiTableEditParamImpl;
import yuyu.common.direct.dscommon.TableMaintenanceUtil;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_BaitaiKbn;
import yuyu.def.classification.C_DsKinouidKbn;
import yuyu.def.classification.C_DsKokyakuJtKbn;
import yuyu.def.classification.C_DsSyoriKbn;
import yuyu.def.classification.C_DsTeisiRiyuuKbn;
import yuyu.def.classification.C_YouhiKbn;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.IT_KykKihon;
import yuyu.def.db.entity.IT_KykSya;
import yuyu.def.db.entity.MT_BAK_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsLoginKanri;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwHonninKakuninInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwHonninKakuninOutputBean;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;
import yuyu.def.hozen.detacher.IT_KykKihonDetacher;
import yuyu.def.hozen.manager.HozenDomManager;


/**
 * 本人確認処理サービスの実装クラスです。<br />
 */
public class DwHonninKakuninImpl implements DwHonninKakunin {

    private static final String HANKAKUSPACE = " ";

    private static final String ZENKAKUSPACE  = "　";

    private static final String BLANK  = "";

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private HozenDomManager hozenDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    private BizDate sysDate;

    private String sysDateTime;

    private String sysTime;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1002)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;

        try {

            wsBzWebserviceResParamBean = honninKakuninMain(pMap);

        } catch (Exception throwable) {
            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            String iwsDsmsgcd = "";

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_002206;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                iwsDsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_002205;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

            WsDwHonninKakuninOutputBean wsDwHonninKakuninOutputBean = SWAKInjector.getInstance(WsDwHonninKakuninOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(iwsDsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwHonninKakuninOutputBean));
        } finally {
            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1002)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    WsBzWebserviceResParamBean honninKakuninMain(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);
        sysDate    = BizDate.getSysDate();
        sysDateTime = BizDate.getSysDateTimeMilli();
        sysTime     = sysDateTime.substring(8, 14);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);

        }
        catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwHonninKakuninInputBean wsDwHonninKakuninInputBean = JSON.decode(gyoumuData, WsDwHonninKakuninInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
                SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
                wsBzWebserviceReqParamBean, wsDwHonninKakuninInputBean);

        WsDwHonninKakuninOutputBean wsDwHonninKakuninOutputBean = SWAKInjector.getInstance(WsDwHonninKakuninOutputBean.class);

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        boolean chkRet = wsDwHonninKakuninInputBean.chkHissuInput();
        if (chkRet == false) {
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_002100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwHonninKakuninOutputBean));

            return wsBzWebserviceResParamBean;
        }

        RayConvertUtil.toValidString(wsDwHonninKakuninInputBean);

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwHonninKakuninInputBean>> chkKekkaSet = validator.validate(wsDwHonninKakuninInputBean);

        if(chkKekkaSet.size() > 0){
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_002100);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwHonninKakuninOutputBean));

            return wsBzWebserviceResParamBean;
        }

        wsDwHonninKakuninOutputBean = honninKakunin(wsDwHonninKakuninInputBean.getIwsSyono(),
                wsDwHonninKakuninInputBean.getIwsDskokno(),
                wsDwHonninKakuninInputBean.getIwsNmkn(),
                BizDate.valueOf(wsDwHonninKakuninInputBean.getIwsSeiymd()),
                wsDwHonninKakuninInputBean.getIwsTelnosimo4());

        wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwHonninKakuninOutputBean));

        return wsBzWebserviceResParamBean;
    }

    private WsDwHonninKakuninOutputBean honninKakunin(String pSyono,
            String pDskokno,
            String pNmkn,
            BizDate pSeiYmd,
            String pTelNoSimo4){

        WsDwHonninKakuninOutputBean wsDwHonninKakuninOutputBean =
                SWAKInjector.getInstance(WsDwHonninKakuninOutputBean.class);
        String saisinLoginYmd = "";
        String saisinLoginTime = "";

        IT_KykKihon itKykKihon = hozenDomManager.getKykKihon(pSyono);

        if (itKykKihon == null) {
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_002204);

            return wsDwHonninKakuninOutputBean;
        }

        IT_KykSya itKykSya = null;
        try {
            itKykSya = IT_KykKihonDetacher.detachKykSyatouched(itKykKihon).getKykSya();
        } catch (EntityNotFoundException eEx) {
        }

        if (itKykSya == null) {
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_002201);

            return wsDwHonninKakuninOutputBean;
        }

        MT_DsKokyakuKanri mtDsKokyakuKanri = directDomManager.getDsKokyakuKanri(pDskokno);

        if (mtDsKokyakuKanri == null) {
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_002203);

            return wsDwHonninKakuninOutputBean;
        }

        MT_DsLoginKanri mtDsLoginKanri = null;
        try {
            mtDsLoginKanri = mtDsKokyakuKanri.getDsLoginKanri();
            if (mtDsLoginKanri.getSyokailoginymd() == null) {
                saisinLoginYmd = "";
                saisinLoginTime = "";
            }
            else {
                saisinLoginYmd = String.valueOf(mtDsLoginKanri.getSaisinloginymd());
                saisinLoginTime = mtDsLoginKanri.getSaisinlogintime();
            }
        } catch (EntityNotFoundException eEx) {
        }

        if (mtDsLoginKanri == null) {
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_002202);

            return wsDwHonninKakuninOutputBean;
        }

        String kinouId     = C_DsKinouidKbn.HONNINKAKUNIN.getValue();
        String userId      = baseUserInfo.getUserId();

        boolean countUpFlg = false;
        int dsKokyakuNmErrorKaisuu     = mtDsLoginKanri.getDskokyakunmerrorkaisuu();
        int dsKokyakuSeiymdErrorKaisuu = mtDsLoginKanri.getDskokyakuseiymderrorkaisuu();
        int dsKokyakuTelNoErrorKaisuu  = mtDsLoginKanri.getDskokyakutelnoerrorkaisuu();
        String kyknmkn = itKykSya.getKyknmkn();

        kyknmkn = kyknmkn.replace(HANKAKUSPACE, BLANK);
        kyknmkn = kyknmkn.replace(ZENKAKUSPACE, BLANK);


        if (!kyknmkn.equals(pNmkn)) {
            dsKokyakuNmErrorKaisuu = dsKokyakuNmErrorKaisuu + 1;
            countUpFlg = true;
        }

        if (BizDateUtil.compareYmd(itKykSya.getKykseiymd(), pSeiYmd) != BizDateUtil.COMPARE_EQUAL) {
            dsKokyakuSeiymdErrorKaisuu =dsKokyakuSeiymdErrorKaisuu + 1;
            countUpFlg = true;
        }

        String telNo = itKykSya.getTsintelno();
        String telNoSimo4 = telNo.substring(telNo.length() - 4);

        if (!telNoSimo4.equals(pTelNoSimo4)) {
            dsKokyakuTelNoErrorKaisuu = dsKokyakuTelNoErrorKaisuu + 1;
            countUpFlg = true;
        }

        boolean lockoutFlg = false;
        int lockoutKiteiKaisuu = YuyuDswebConfig.getInstance().getLockoutKiteiKaisuu();

        if (dsKokyakuNmErrorKaisuu >= lockoutKiteiKaisuu
                || dsKokyakuSeiymdErrorKaisuu >= lockoutKiteiKaisuu
                || dsKokyakuTelNoErrorKaisuu >= lockoutKiteiKaisuu) {

            lockoutFlg = true;
        }

        DsSaibanSyori dsSaibanSyori = SWAKInjector.getInstance(DsSaibanSyori.class);

        String dsHenkousikibetukey = dsSaibanSyori.saibanDsHenkouSikibetukey();

        TableMaintenanceUtil tableMaintenanceUtil = SWAKInjector.getInstance(TableMaintenanceUtil.class);

        MT_BAK_DsKokyakuKanri bakDsKokyakuKanri = tableMaintenanceUtil.exec(pDskokno, dsHenkousikibetukey);

        directDomManager.insert(bakDsKokyakuKanri);

        if (lockoutFlg) {
            mtDsKokyakuKanri.setDskokyakujtkbn(C_DsKokyakuJtKbn.ITIJI_TEISI);
            mtDsKokyakuKanri.setDsteisiriyuukbn(C_DsTeisiRiyuuKbn.LOCK_OUT);
            mtDsKokyakuKanri.setDskokyakumukouymd(sysDate);
            mtDsKokyakuKanri.setGyoumuKousinKinou(kinouId);
            mtDsKokyakuKanri.setGyoumuKousinsyaId(userId);
            mtDsKokyakuKanri.setGyoumuKousinTime(sysDateTime);
        }

        if (!countUpFlg) {

            if (mtDsLoginKanri.getSyokailoginymd() == null) {
                mtDsLoginKanri.setSyokailoginymd(sysDate);
                mtDsLoginKanri.setSyokailogintime(sysTime);
                mtDsLoginKanri.setSyokailoginbaitaikbn(C_BaitaiKbn.PC);
            }

            mtDsLoginKanri.setSaisinloginymd(sysDate);
            mtDsLoginKanri.setSaisinlogintime(sysTime);
            mtDsLoginKanri.setSaisinloginbaitaikbn(C_BaitaiKbn.PC);
            mtDsLoginKanri.setDshnnkakcderrorkaisuu(0);
            mtDsLoginKanri.setDskokyakunmerrorkaisuu(0);
            mtDsLoginKanri.setDskokyakuseiymderrorkaisuu(0);
            mtDsLoginKanri.setDskokyakutelnoerrorkaisuu(0);

        }
        else {
            mtDsLoginKanri.setDskokyakunmerrorkaisuu(dsKokyakuNmErrorKaisuu);
            mtDsLoginKanri.setDskokyakuseiymderrorkaisuu(dsKokyakuSeiymdErrorKaisuu);
            mtDsLoginKanri.setDskokyakutelnoerrorkaisuu(dsKokyakuTelNoErrorKaisuu);
        }

        mtDsLoginKanri.setGyoumuKousinKinou(kinouId);
        mtDsLoginKanri.setGyoumuKousinsyaId(userId);
        mtDsLoginKanri.setGyoumuKousinTime(sysDateTime);

        try {
            directDomManager.update(mtDsKokyakuKanri);
        } catch (Exception e) {
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_002200);

            return wsDwHonninKakuninOutputBean;
        }

        DsTetudukiRirekiTableEdit dsTetudukiRirekiTableEdit =
                SWAKInjector.getInstance(DsTetudukiRirekiTableEdit.class);
        DsTetudukiRirekiTableEditParamImpl dsEditTtdkRirekiTblParam =
                SWAKInjector.getInstance(DsTetudukiRirekiTableEditParamImpl.class);
        AS_Kinou kinou = new AS_Kinou();

        kinou.setKinouId(C_DsKinouidKbn.HONNINKAKUNIN.getValue());

        dsEditTtdkRirekiTblParam.setDskokno(pDskokno);
        dsEditTtdkRirekiTblParam.setHenkousikibetukey(dsHenkousikibetukey);
        dsEditTtdkRirekiTblParam.setSyoriYmd(sysDate);
        if(countUpFlg){
            dsEditTtdkRirekiTblParam.setDssyorikbn(C_DsSyoriKbn.HONNIN_KAKUNIN_SIPPAI);
        }else{
            dsEditTtdkRirekiTblParam.setDssyorikbn(C_DsSyoriKbn.HONNIN_KAKUNIN_SEIKOU);
        }
        dsEditTtdkRirekiTblParam.setHenkouRrkYouhi(C_YouhiKbn.YOU);
        dsTetudukiRirekiTableEdit.editDSTtdkRirekiTblWebService(dsEditTtdkRirekiTblParam, kinou);

        if (lockoutFlg) {
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_002001);
            wsDwHonninKakuninOutputBean.setIwsSaisinloginymd("");
            wsDwHonninKakuninOutputBean.setIwsSaisinlogintime("");
        }
        else if (countUpFlg) {
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_002002);
            wsDwHonninKakuninOutputBean.setIwsSaisinloginymd("");
            wsDwHonninKakuninOutputBean.setIwsSaisinlogintime("");
        }
        else {
            wsDwHonninKakuninOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_002003);
            wsDwHonninKakuninOutputBean.setIwsSaisinloginymd(saisinLoginYmd);
            wsDwHonninKakuninOutputBean.setIwsSaisinlogintime(saisinLoginTime);
        }

        return wsDwHonninKakuninOutputBean;
    }
}
