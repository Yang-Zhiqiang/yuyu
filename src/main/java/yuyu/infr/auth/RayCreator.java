package yuyu.infr.auth;

import static yuyu.infr.auth.RayHttpHeaderConstans.*;

import javax.servlet.http.HttpServletRequest;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.slf4j.Logger;

import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.db.entity.AM_Sosiki;

import com.google.common.base.Strings;

/**
 * HTTPリクエストヘッダに格納されている認証情報を専用のBEANに詰めるユーティリティです。
 */
public class RayCreator {

    public static void create(){
        loggingHeaderBean("認証情報設定前");

        RayHttpHeaderBean  headerBean = SWAKInjector.getInstance(RayHttpHeaderBean.class);
        RayBCPBean          bcpBean     = SWAKInjector.getInstance(RayBCPBean.class);

        if(bcpBean.isBcp()){
            headerBean.setTmSosikiCd(bcpBean.getDaikouSosikiCd());
            headerBean.setTmSosikiNm(getTmSosikiNm(headerBean.getTmSosikiCd()));
        }else{
            HttpServletRequest request    = SWAKInjector.getInstance(HttpServletRequest.class);
            headerBean.setTmSosikiCd  (request.getHeader(MAC_ORG_CODE));
            headerBean.setTmSosikiNm  (getTmSosikiNm(headerBean.getTmSosikiCd()));
            headerBean.setSsoId       (request.getHeader(USER_ID));
            headerBean.setIdKind      (request.getHeader(ID_KIND));
            headerBean.setPersonCd    (request.getHeader(PERSON_CODE));
            headerBean.setIssueNum    (request.getHeader(ISSUE_NUMBER));
            headerBean.setPcCd        (request.getHeader(PC_CODE));
            headerBean.setIpAddress   (request.getHeader(IPADDR));
            headerBean.setMachineKind (request.getHeader(MACHINE));
            headerBean.setNodeNum     (request.getHeader(NODE_NUMBER));
        }

        loggingHeaderBean("認証情報設定後");

    }

    public static void recreate(RayHttpHeaderBean orginalBean){
        loggingHeaderBean("認証情報再設定前");

        RayHttpHeaderBean headerBean = SWAKInjector.getInstance(RayHttpHeaderBean.class);
        headerBean.setTmSosikiCd (orginalBean.getTmSosikiCd());
        headerBean.setTmSosikiNm (orginalBean.getTmSosikiNm());
        headerBean.setSsoId      (orginalBean.getSsoId());
        headerBean.setIdKind     (orginalBean.getIdKind());
        headerBean.setPersonCd   (orginalBean.getPersonCd());
        headerBean.setIssueNum   (orginalBean.getIssueNum());
        headerBean.setPcCd       (orginalBean.getPcCd());
        headerBean.setIpAddress  (orginalBean.getIpAddress());
        headerBean.setMachineKind(orginalBean.getMachineKind());
        headerBean.setNodeNum    (orginalBean.getNodeNum());

        loggingHeaderBean("認証情報再設定後");
    }

    public static boolean chkAuthInfoIsEmpty(){
        RayHttpHeaderBean headerBean = SWAKInjector.getInstance(RayHttpHeaderBean.class);

        if(  !Strings.isNullOrEmpty(headerBean.getSsoId())
          || !Strings.isNullOrEmpty(headerBean.getIdKind())
          || !Strings.isNullOrEmpty(headerBean.getPersonCd())
          || !Strings.isNullOrEmpty(headerBean.getIssueNum())
          || !Strings.isNullOrEmpty(headerBean.getPcCd())
          || !Strings.isNullOrEmpty(headerBean.getIpAddress())
          || !Strings.isNullOrEmpty(headerBean.getMachineKind())
          || !Strings.isNullOrEmpty(headerBean.getNodeNum())
          || !Strings.isNullOrEmpty(headerBean.getTmSosikiCd())){
            return false;
        }

        return true;

    }

    private static String getTmSosikiNm(String pSosikiCd){
        BaseDomManager dom = SWAKInjector.getInstance(BaseDomManager.class);
        AM_Sosiki sosiki = dom.getSosiki(pSosikiCd == null ? "" : pSosikiCd);
        if(sosiki == null){
            return null;
        }
        return sosiki.getKanjisosikinm20();
    }

    private static void loggingHeaderBean(String message) {
        RayHttpHeaderBean headerBean = SWAKInjector.getInstance(RayHttpHeaderBean.class);

        Logger logger = LoggerFactory.getLogger(RayCreator.class);

        if (logger.isDebugEnabled()) {
            logger.debug("◇ RayHttpHeaderBean（{}）", message);
            logger.debug("｜  tmSosikiCd  = {}", headerBean.getTmSosikiCd());
            logger.debug("｜  tmSosikiNm  = {}", headerBean.getTmSosikiNm());
            logger.debug("｜  ssoId       = {}", headerBean.getSsoId());
            logger.debug("｜  idKind      = {}", headerBean.getIdKind());
            logger.debug("｜  personCd    = {}", headerBean.getPersonCd());
            logger.debug("｜  issueNum    = {}", headerBean.getIssueNum());
            logger.debug("｜  pcCd        = {}", headerBean.getPcCd());
            logger.debug("｜  ipAddress   = {}", headerBean.getIpAddress());
            logger.debug("｜  machineKind = {}", headerBean.getMachineKind());
            logger.debug("｜  nodeNum     = {}", headerBean.getNodeNum());
            logger.debug("◇ RayHttpHeaderBean");
        }
    }
}
