package yuyu.app.dsweb.dwcommon.dwhukamojicheck;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.MultivaluedMap;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.util.message.MessageUtil;
import net.arnx.jsonic.JSON;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;

import yuyu.common.biz.bzwebserviceaccesslogoutput.WebServiceAccesslogOutput;
import yuyu.common.dsweb.dwcommon.DwMessageCodeConstants;
import yuyu.def.MessageId;
import yuyu.def.biz.bean.param.WsBzWebserviceReqParamBean;
import yuyu.def.biz.bean.param.WsBzWebserviceResParamBean;
import yuyu.def.classification.C_AccessLogSyubetuKbn;
import yuyu.def.dsweb.bean.webservice.WsDwHukamojiCheckInputBean;
import yuyu.def.dsweb.bean.webservice.WsDwHukamojiCheckOutputBean;

/**
 * 不可文字チェックサービスの実装クラスです。<br />
 */
public class DwHukamojiCheckImpl implements DwHukamojiCheck {

    public static final String CHECK_NG = "0";

    public static final String CHECK_OK = "1";

    @Inject
    private static Logger logger;

    @Override
    public WsBzWebserviceResParamBean execPostForm(MultivaluedMap<String, String> pMap) {

        logger.info(MessageUtil.getMessage(MessageId.IBF0016, MessageUtil.getMessage(MessageId.INW1008)));

        WsBzWebserviceReqParamBean wsBzWebserviceReqParamBean = SWAKInjector.getInstance(WsBzWebserviceReqParamBean.class);

        try {
            BeanUtils.populate(wsBzWebserviceReqParamBean, pMap);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        catch(InvocationTargetException e){
            throw new RuntimeException(e);
        }
        String gyoumuData = wsBzWebserviceReqParamBean.getGyoumuData();

        WsDwHukamojiCheckInputBean wsDwHukamojiCheckInputBean =
            JSON.decode(gyoumuData, WsDwHukamojiCheckInputBean.class);

        WebServiceAccesslogOutput webServiceAccesslogOutput =
            SWAKInjector.getInstance(WebServiceAccesslogOutput.class);
        webServiceAccesslogOutput.exec(C_AccessLogSyubetuKbn.ACTION_BEGIN,
            wsBzWebserviceReqParamBean, wsDwHukamojiCheckInputBean);

        WsDwHukamojiCheckOutputBean wsDwHukamojiCheckOutputBean = SWAKInjector.getInstance(WsDwHukamojiCheckOutputBean.class);

        WsBzWebserviceResParamBean webserviceResParamBean = SWAKInjector.getInstance(WsBzWebserviceResParamBean.class);

        List<String> checkObjLst = wsDwHukamojiCheckInputBean.getIwsCheckObjLst();

        List<String> checkKekkaLst = new ArrayList<>();

        Validator validator = SWAKInjector.getInstance(Validator.class);

        for (String checkObj : checkObjLst) {
            wsDwHukamojiCheckInputBean.setIwsCheckmojiretu(checkObj);

            Set<ConstraintViolation<WsDwHukamojiCheckInputBean>> chkKekkaSet =
                validator.validate(wsDwHukamojiCheckInputBean);

            if(chkKekkaSet.size() > 0) {
                checkKekkaLst.add(CHECK_NG);
            }
            else {
                checkKekkaLst.add(CHECK_OK);
            }

            wsDwHukamojiCheckInputBean.setIwsCheckmojiretu("");
        }

        wsDwHukamojiCheckOutputBean.setIwsDsmsgcd(DwMessageCodeConstants.IWSDSMSGCD_008000);
        wsDwHukamojiCheckOutputBean.setIwsCheckKekkaLst(checkKekkaLst);

        webserviceResParamBean.setGyoumuData(
            JSON.encode(wsDwHukamojiCheckOutputBean));

        logger.info(MessageUtil.getMessage(MessageId.IBF0017, MessageUtil.getMessage(MessageId.INW1008)));

        return webserviceResParamBean;
    }
}
