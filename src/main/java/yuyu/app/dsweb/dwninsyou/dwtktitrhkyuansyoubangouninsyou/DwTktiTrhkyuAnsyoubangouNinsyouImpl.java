package yuyu.app.dsweb.dwninsyou.dwtktitrhkyuansyoubangouninsyou;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
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
import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.direct.dscommon.DsDB2Util;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.classification.C_DsTrhkserviceRiyoujkKbn;
import yuyu.def.classification.C_DsTrhkserviceTeisiRiyuuKbn;
import yuyu.def.db.entity.MT_DsKokyakuKanri;
import yuyu.def.db.entity.MT_DsKokyakuKeiyaku;
import yuyu.def.db.entity.MT_DsTorihikiServiceKanri;
import yuyu.def.db.entity.MT_DsTorihikiyouAnsyono;
import yuyu.def.direct.manager.DirectDomManager;
import yuyu.def.dsweb.bean.webservice.WsDwTktiTrhkyuAnsyoubangouNinsyouInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean;
import yuyu.def.dsweb.configuration.YuyuDswebConfig;

/**
 * ＤＳ特定取引用暗証番号認証サービスの実装クラスです。<br />
 */
public class DwTktiTrhkyuAnsyoubangouNinsyouImpl implements DwTktiTrhkyuAnsyoubangouNinsyou {

    private static final String KINOUID = "dwtktitrhkyuansyoubangouninsyou";

    @Inject
    private static Logger logger;

    @Inject
    private DirectDomManager directDomManager;

    @Inject
    private BaseUserInfo baseUserInfo;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1012)));

        WsBzWebserviceResParamBean wsBzWebserviceResParamBean;
        String dsmsgcd = "";

        try {

            dsmsgcd = ansyobangouNinsyouMain(pMap);

        } catch (Exception throwable) {

            DsDB2Util dsDB2Util = SWAKInjector.getInstance(DsDB2Util.class);

            DsDB2Util.E_Result result = dsDB2Util.exec(throwable);

            if (DsDB2Util.E_Result.DEADLOCK.compareTo(result) == 0) {
                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014205;
            }
            else if (DsDB2Util.E_Result.QUERY_TIMEOUT.compareTo(result) == 0) {
                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014204;
            }
            else if (DsDB2Util.E_Result.OTHER.compareTo(result) == 0) {
                throw throwable;
            }

        } finally {

            WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean wsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean =
                SWAKInjector.getInstance(WsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.class);
            wsBzWebserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);
            wsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean.setIwsDsmsgcd(dsmsgcd);
            wsBzWebserviceResParamBean.setGyoumuData(JSON.encode(wsDwTktiTrhkyuAnsyoubangouNinsyouOutputBean));

            logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1012)));
        }

        return wsBzWebserviceResParamBean;
    }

    @Transactional
    String ansyobangouNinsyouMain(MultivaluedMap<String, String> pMap) {

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector
            .getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwTktiTrhkyuAnsyoubangouNinsyouInputBean inputBean =
            JSON.decode(gyoumuData, WsDwTktiTrhkyuAnsyoubangouNinsyouInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, inputBean);

        String dsmsgcd = "";

        boolean chkRet = inputBean.chkInput();
        if (!chkRet) {

            dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014100;

            return dsmsgcd;
        }

        Validator validator = SWAKInjector.getInstance(Validator.class);
        Set<ConstraintViolation<WsDwTktiTrhkyuAnsyoubangouNinsyouInputBean>> chkKekkaSet =
            validator.validate(inputBean);

        if (chkKekkaSet.size() > 0) {

            dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014100;

            return dsmsgcd;
        }

        dsmsgcd = ansyobangouNinsyou(inputBean.getIwsDskokno(), inputBean.getIwsSyono(),
            inputBean.getIwsTokuteitrhkansyono());

        return dsmsgcd;
    }

    private String ansyobangouNinsyou(String pDskokno, String pSyono, String pTokuteitrhkansyono) {

        boolean authenticateFlg = false;
        boolean lockoutFlg = false;
        String dsmsgcd = "";

        MT_DsKokyakuKanri dsKokyakuKanri = directDomManager.getDsKokyakuKanri(pDskokno);
        MT_DsKokyakuKeiyaku dsKokyakuKeiyaku = dsKokyakuKanri.getDsKokyakuKeiyakuBySyono(pSyono);
        MT_DsTorihikiServiceKanri dsTorihikiServiceKanri = dsKokyakuKeiyaku.getDsTorihikiServiceKanri();

        if (dsTorihikiServiceKanri == null) {

            dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014201;

            return dsmsgcd;
        }

        if (C_DsTrhkserviceRiyoujkKbn.RIYOU_KA.eq(dsTorihikiServiceKanri.getDstrhkserviceriyoujkkbn())) {
        }
        else {
            if (C_DsTrhkserviceTeisiRiyuuKbn.LOCK_OUT.eq(dsTorihikiServiceKanri.getDstrhkserviceteisiriyuukbn())) {

                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014001;
            }
            else {

                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014003;
            }

            return dsmsgcd;
        }

        List<MT_DsTorihikiyouAnsyono> dsTorihikiyouAnsyonoLst = dsTorihikiServiceKanri.getDsTorihikiyouAnsyonos();
        if (dsTorihikiyouAnsyonoLst.size() == 0) {
            dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014203;

            return dsmsgcd;
        }

        MT_DsTorihikiyouAnsyono dsTorihikiyouAnsyono = dsTorihikiyouAnsyonoLst.get(0);

        if (pTokuteitrhkansyono.equals(dsTorihikiyouAnsyono.getTokuteitrhkansyono())) {
            authenticateFlg = true;
        }

        if (!authenticateFlg) {
            dsTorihikiyouAnsyono.setTktrhkansyonoerrorkaisuu(dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu() + 1);

            if (dsTorihikiyouAnsyono.getTktrhkansyonoerrorkaisuu() >= YuyuDswebConfig.getInstance()
                .getLockoutKiteiKaisuu()) {

                lockoutFlg = true;
            }
        }

        String userId = baseUserInfo.getUserId();
        String sysDateTimeMilli = BizDate.getSysDateTimeMilli();
        BizDate sysDate = BizDate.getSysDate();

        if (lockoutFlg) {

            dsTorihikiServiceKanri.setDstrhkserviceriyoujkkbn(C_DsTrhkserviceRiyoujkKbn.RIYOU_HUKA);
            dsTorihikiServiceKanri.setDstrhkserviceteisiriyuukbn(C_DsTrhkserviceTeisiRiyuuKbn.LOCK_OUT);
            dsTorihikiServiceKanri.setDstrhkservicemukouymd(sysDate);
            dsTorihikiServiceKanri.setGyoumuKousinKinou(KINOUID);
            dsTorihikiServiceKanri.setGyoumuKousinsyaId(userId);
            dsTorihikiServiceKanri.setGyoumuKousinTime(sysDateTimeMilli);

            try {
                directDomManager.update(dsKokyakuKanri);

            } catch (Exception e) {

                dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014200;
                return dsmsgcd;
            }
        }

        if (authenticateFlg) {

            dsTorihikiyouAnsyono.setTktrhkansyonoerrorkaisuu(0);
        }
        dsTorihikiyouAnsyono.setGyoumuKousinKinou(KINOUID);
        dsTorihikiyouAnsyono.setGyoumuKousinsyaId(userId);
        dsTorihikiyouAnsyono.setGyoumuKousinTime(sysDateTimeMilli);

        try {
            directDomManager.update(dsKokyakuKanri);

        } catch (Exception e) {

            dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014202;
            return dsmsgcd;
        }

        if (lockoutFlg) {
            dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014001;
        }
        else if (!authenticateFlg) {
            dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014002;
        }
        else {
            dsmsgcd = DwMessageCodeConstants.IWSDSMSGCD_014000;
        }

        return dsmsgcd;
    }

}
