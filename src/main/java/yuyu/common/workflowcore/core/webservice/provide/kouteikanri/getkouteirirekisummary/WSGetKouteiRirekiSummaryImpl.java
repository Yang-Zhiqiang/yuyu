package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import jp.co.slcs.swak.core.logger.LoggerFactory;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import yuyu.common.workflowcore.core.iwfinfr.util.IwfDateUtils;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfEditMessageUtil;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageCd;
import yuyu.common.workflowcore.core.iwfinfr.util.IwfMessageUtil;
import yuyu.common.workflowcore.core.webservice.common.WSExtParam;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic;
import yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary.IWSGetKouteiRirekiSummaryIOKey.MapKey;
import yuyu.common.workflowcore.iwfcommon.CheckException;
import yuyu.def.classification.C_ResultCdKbn;
import yuyu.def.db.entity.WT_KouteiSummary;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;

/**
 * 【Ｊ社カスタマイズ】工程履歴サマリ取得サービスのプロバイダークラスです。<br />
 * <p>
 * 検索条件に紐づく工程処理履歴サマリを取得します。<br />
 * 複数の業務キーを入力に、紐づく案件情報と、履歴情報のサマライズ情報を取得します。<br />
 * <p>
 * 注意：<br />
 * 当クラスは、Ｊ社に依存したつくりになっています。
 * Ｊ社では特に工程サマリ機能について性能を求める要件があり、
 * 通常Iwfcoreでは、jBPM3に依存したコーディングはしませんが、
 * このクラスに限りjBPM3に依存したコーディングを許しています。
 * したがって、jBPM3以外を使う場合や、
 */
public class WSGetKouteiRirekiSummaryImpl implements WSGetKouteiRirekiSummary {

    @Inject
    private IwfCoreDomManager iwfCoreDomManager;
    final static Logger LOGGER = LoggerFactory.getLogger(WSGetKouteiRirekiSummaryImpl.class);

    public WSGetKouteiRirekiSummaryImpl () {
        super();
    }

    WSGetKouteiRirekiSummaryResponse validate(
        WSGetKouteiRirekiSummaryRequest request) throws Exception {

        LOGGER.debug("│バリデーションチェック処理を開始します。");

        WSGetKouteiRirekiSummaryResponse oResponse = new WSGetKouteiRirekiSummaryResponse();

        String sKouteikaisibifrom   = request.getKouteikaisibifrom();
        String sKouteikaisibito     = request.getKouteikaisibito();
        String sKouteikanryoubifrom = request.getKouteikanryoubifrom();
        String sKouteikanryoubito   = request.getKouteikanryoubito();
        String sLastsyoritimefrom   = request.getLastsyoritimefrom();
        String sLastsyoritimeto     = request.getLastsyoritimeto();


        if (StringUtils.isNotEmpty(sKouteikaisibifrom)) {
            if(!IwfDateUtils.checkDateYYYYMMDD(sKouteikaisibifrom)){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2161);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sKouteikaisibito)) {
            if(!IwfDateUtils.checkDateYYYYMMDD(sKouteikaisibito)){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2162);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sKouteikanryoubifrom)) {
            if(!IwfDateUtils.checkDateYYYYMMDD(sKouteikanryoubifrom)){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2163);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sKouteikanryoubito)) {
            if(!IwfDateUtils.checkDateYYYYMMDD(sKouteikanryoubito)){
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2164);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sLastsyoritimefrom)) {
            if (!IwfDateUtils.checkDate(sLastsyoritimefrom)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2165);
                return oResponse;
            }
        }

        if (StringUtils.isNotEmpty(sLastsyoritimeto)) {
            if (!IwfDateUtils.checkDate(sLastsyoritimeto)) {
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2166);
                return oResponse;
            }
        }


        if ((StringUtils.isNotEmpty(sKouteikaisibifrom) && StringUtils.isEmpty(sKouteikaisibito))
            || (StringUtils.isEmpty(sKouteikaisibifrom) && StringUtils.isNotEmpty(sKouteikaisibito))) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2167);
            return oResponse;
        }

        if ((StringUtils.isNotEmpty(sKouteikanryoubifrom) && StringUtils.isEmpty(sKouteikanryoubito))
            || (StringUtils.isEmpty(sKouteikanryoubifrom) && StringUtils.isNotEmpty(sKouteikanryoubito))) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2168);
            return oResponse;
        }

        if ((StringUtils.isNotEmpty(sLastsyoritimefrom) && StringUtils.isEmpty(sLastsyoritimeto))
            || (StringUtils.isEmpty(sLastsyoritimefrom) && StringUtils.isNotEmpty(sLastsyoritimeto))) {
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2169);
            return oResponse;
        }


        return oResponse;
    }

    public String getServiceName() {
        return WSGetKouteiRirekiSummaryRequest.sSERVICE_NAME;
    }

    @Override
    public WSGetKouteiRirekiSummaryResponse executeBizMain(
        WSGetKouteiRirekiSummaryRequest request) throws Exception {

        LOGGER.debug("|主処理を開始します。");

        long time = 0;

        time = System.currentTimeMillis();

        WSGetKouteiRirekiSummaryResponse oResponse = new WSGetKouteiRirekiSummaryResponse();

        oResponse = validate(request);

        if (C_ResultCdKbn.NG.toString().equals(oResponse.getKekkastatus())) {
            return oResponse;
        }

        String sInRequestId         = request.getRequestid();
        String sInGyoumukey         = request.getGyoumukey();
        String[] sInGyoumukeys      = request.getGyoumukeys();
        if(null == sInGyoumukeys  && null != sInGyoumukey){
            sInGyoumukeys = new String[]{sInGyoumukey};
        }
        String sInFlowid              = request.getFlowid();
        String[] sInFlowids           = request.getFlowids();
        if(null == sInFlowids && null != sInFlowid){
            sInFlowids =  new String[]{sInFlowid};
        }

        final String sKouteikaisibifrom   = request.getKouteikaisibifrom();
        final String sKouteikaisibito     = request.getKouteikaisibito();
        final String sKouteikanryoubifrom = request.getKouteikanryoubifrom();
        final String sKouteikanryoubito   = request.getKouteikanryoubito();
        final String sLastsyoritimefrom = request.getLastsyoritimefrom();
        final String sLastsyoritimeto = request.getLastsyoritimeto();
        final String[] sSyoristatus         = request.getSyoristatus();
        String sAccountid           = request.getAccountid();
        String sNodename            = request.getNodename();
        String sAccountwariateUmu   = request.getAccountwariateumu();
        String sKekkajyougenkensu   = request.getKekkajyougenkensu();
        if(StringUtils.isEmpty(sKekkajyougenkensu )){
            sKekkajyougenkensu = "10000";
        }

        Map<String, WSExtParam> extParamMap = IwfCommonLogic.getExtParams(request);

        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("▼リクエストパラメータ");
            LOGGER.debug("│ リクエストID             : " + sInRequestId);
            LOGGER.debug("│ 業務キー                 : " + sInGyoumukey);
            if (null == sInGyoumukeys) {
                LOGGER.debug("│ 業務キー(配列)                 : " + sInGyoumukeys);
            } else {
                LOGGER.debug("│ 業務キー(配列)           : " + "[" + Joiner.on(", ").join(sInGyoumukeys) + "]");
            }
            if (null == sInFlowids) {
                LOGGER.debug("│ フローＩＤ(配列)                 : " + sInFlowids);
            } else {
                LOGGER.debug("│ フローＩＤ(配列)           : " + "[" + Joiner.on(", ").join(sInFlowids) + "]");
            }
            LOGGER.debug("│ フローＩＤ               : " + sInFlowid);
            LOGGER.debug("│ 工程開始日付(自)         : " + sKouteikaisibifrom);
            LOGGER.debug("│ 工程開始日付(至)         : " + sKouteikaisibito);
            LOGGER.debug("│ 工程完了日付(自)         : " + sKouteikanryoubifrom);
            LOGGER.debug("│ 工程完了日付(至)         : " + sKouteikanryoubito);
            LOGGER.debug("│ 最終処理時間(自)         : " + sLastsyoritimefrom);
            LOGGER.debug("│ 最終処理時間(至)         : " + sLastsyoritimeto);
            if (null == sSyoristatus) {
                LOGGER.debug("│ 処理状態                 : " + sSyoristatus);
            } else {
                LOGGER.debug("│ 処理状態           : " + "[" + Joiner.on(", ").join(sSyoristatus) + "]");
            }
            LOGGER.debug("│ アカウントＩＤ           : " + sAccountid);
            LOGGER.debug("│ ノード名                 : " + sNodename);
            LOGGER.debug("│ アカウント割当有無フラグ : " + sAccountwariateUmu);
            LOGGER.debug("└ 結果上限件数             : " + sKekkajyougenkensu);
        }

        try {
            LOGGER.debug("■◇■◇■【計測】1. DBアクセス[件数取得]前処理　　　：" + (System.currentTimeMillis() - time));
            time = System.currentTimeMillis();

            Long kouteiCount = iwfCoreDomManager.getCountKouteiSummary(sInGyoumukeys, sInFlowids, sKouteikaisibifrom,
                sKouteikaisibito, sKouteikanryoubifrom, sKouteikanryoubito, sLastsyoritimefrom, sLastsyoritimeto,
                sSyoristatus, sAccountid, sAccountwariateUmu, sNodename, extParamMap);

            LOGGER.debug("■◇■◇■【計測】2. DBアクセス[件数取得]実処理　　　：" + (System.currentTimeMillis() - time) + "　　　　　取得件数:" +   kouteiCount + "(" + sKekkajyougenkensu + ")");
            time = System.currentTimeMillis();

            if(kouteiCount.intValue() > Integer.parseInt(sKekkajyougenkensu)) {

                LOGGER.debug("上限件数チェックエラーが発生しました。取得数；" + kouteiCount + ", 上限件数；" + sKekkajyougenkensu);
                IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF2160);
                return oResponse;
            }

            LOGGER.debug("■◇■◇■【計測】3. DBアクセス[実データ取得]前処理　　　：" + (System.currentTimeMillis() - time));
            time = System.currentTimeMillis();

            List<WT_KouteiSummary> kouteiSummarys = iwfCoreDomManager.getKouteiSummarys(sInGyoumukeys, sInFlowids,
                sKouteikaisibifrom, sKouteikaisibito, sKouteikanryoubifrom, sKouteikanryoubito, sLastsyoritimefrom,
                sLastsyoritimeto, sSyoristatus, sAccountid, sAccountwariateUmu, sNodename, extParamMap);

            LOGGER.debug("■◇■◇■【計測】4. DBアクセス[実データ取得]実処理　　　：" + (System.currentTimeMillis() - time) + "　　　　　取得件数:" + kouteiSummarys.size() + "(" + Integer.parseInt(sKekkajyougenkensu) + ")");
            time = System.currentTimeMillis();


            List<Map<String, String>> oRirekimaps = new ArrayList<Map<String,String>>();

            long inTime = 0;
            long wkTime = 0;
            for(WT_KouteiSummary elm : kouteiSummarys){

                String gyoumukey           = elm.getGyoumuKey();
                String flowId              = elm.getFlowId();
                String lastUpdate          = elm.getLastSyoriTime();
                String firstAccoutId       = elm.getSyokaiAccountId();
                String previousAccountId   = elm.getZenkaiAccountId();
                String previousNodeNm      = elm.getZenkaiNodeNm();
                String previousNodeLocalNm = elm.getZenkaiTaskLocalNm();
                String nodeName            = elm.getNodeNm();
                String actorId             = elm.getGenzaiAccountId();
                String nodeLocalName       = elm.getGenzaiTaskLocalNm();
                String kouteikaisibi       = elm.getIwfKouteiKaisiYmd();
                String kouteikanryoubi     = elm.getKouteiKanryouYmd();
                String syoristatus         = elm.getSyoriStatus();

                wkTime = System.currentTimeMillis();

                LOGGER.trace("業務キー:" + gyoumukey + "のサマリ");
                LOGGER.trace(Objects.toStringHelper(this)
                    .add("gyoumukey", gyoumukey)
                    .toString());

                if(LOGGER.isTraceEnabled()){
                    LOGGER.trace( "┌【業務キー = " + gyoumukey  +"】" );
                    LOGGER.trace( "│ (01)工程開始日付               : " + kouteikaisibi );
                    LOGGER.trace( "│ (02)工程完了日付               : " + kouteikanryoubi );
                    LOGGER.trace( "│ (03)工程状態                   : " + syoristatus );
                    LOGGER.trace( "│ (04)最終更新時間               : " + lastUpdate );
                    LOGGER.trace( "│ (05)初回担当者ID               : " + firstAccoutId );
                    LOGGER.trace( "│ (06)前回担当者ID               : " + previousAccountId );
                    LOGGER.trace( "│ (07)前回ノード名               : " + previousNodeNm );
                    LOGGER.trace( "│ (08)前回ノード名（ローカル名） : " + previousNodeLocalNm );
                    LOGGER.trace( "│ (09)現在担当者ID               : " + actorId );
                    LOGGER.trace( "│ (10)現在ノード名               : " + nodeName );
                    LOGGER.trace( "│ (11)現在ノード名（ローカル名） : " + nodeLocalName );
                }

                inTime = inTime + System.currentTimeMillis() - wkTime;

                Map<String, String> oRirekimap = new HashMap<String, String>();
                oRirekimap.put(MapKey.sS_FLOWID                  , flowId);
                oRirekimap.put(MapKey.sS_GYOUMUKEY               , gyoumukey);
                oRirekimap.put(MapKey.sS_KOUTEI_KAISIBI          , kouteikaisibi);
                oRirekimap.put(MapKey.sS_KOUTEI_KANRYOUBI        , kouteikanryoubi);
                oRirekimap.put(MapKey.sS_SYORI_STATUS            , syoristatus);
                oRirekimap.put(MapKey.sS_LAST_UPDATE             , lastUpdate);
                oRirekimap.put(MapKey.sS_FIRST_ACCOUNTID         , firstAccoutId);
                oRirekimap.put(MapKey.sS_PREVIOUS_ACCOUNTID      , previousAccountId);
                oRirekimap.put(MapKey.sS_PREVIOUS_NODENAME       , previousNodeNm);
                oRirekimap.put(MapKey.sS_PREVIOUS_NODELOCALNAME  , previousNodeLocalNm);
                oRirekimap.put(MapKey.sS_ACCOUNTID               , actorId);
                oRirekimap.put(MapKey.sS_NODENAME                , nodeName);
                oRirekimap.put(MapKey.sS_NODELOCALNAME           , nodeLocalName);

                setExtParams(elm, oRirekimap);

                wkTime = System.currentTimeMillis();

                inTime = inTime + System.currentTimeMillis() - wkTime;

                oRirekimaps.add(oRirekimap);
            }

            LOGGER.debug("■◇■◇■【計測】5. 戻り値編集ループ　　　：" + (System.currentTimeMillis() - time));
            LOGGER.debug("■◇■◇■【計測】 └ うちロギング時間分 　：" + inTime);
            time = System.currentTimeMillis();

            oResponse.setRirekimaps(oRirekimaps.toArray(new Map[]{}));
            IwfEditMessageUtil.setMsgResultOK(oResponse, "工程履歴サマリ取得");

            LOGGER.debug("■◇■◇■【計測】6. メソッド終了　　　　　：" + (System.currentTimeMillis() - time));

        }
        catch (Exception e) {

            if(SWAKInjector.getInstance(CheckException.class).isExceptionShouldThrow(e)){
                throw e;
            }

            LOGGER.error("想定外のエラーが発生しました。", e);
            IwfEditMessageUtil.setMsgResultNG(oResponse, IwfMessageCd.IWF0001, "工程履歴サマリ取得");
        } finally {

            time = System.currentTimeMillis();

            LOGGER.debug("■◇■◇■【計測】7. メソッド終了　　　　　：" + (System.currentTimeMillis() - time));

        }

        LOGGER.debug("|主処理を終了します。");
        return oResponse;
    }

    public WSGetKouteiRirekiSummaryResponse getStubResult(
        WSGetKouteiRirekiSummaryRequest request) throws Exception {
        return null;
    }

    public WSGetKouteiRirekiSummaryResponse getBootErrResponse() {
        WSGetKouteiRirekiSummaryResponse res = new WSGetKouteiRirekiSummaryResponse();
        res.setKekkastatus(C_ResultCdKbn.OK.getValue());
        res.setSyousaimsgcd(IwfMessageCd.IWF0003.toString());
        res.setSyousaimsg(IwfMessageUtil.getMessage(IwfMessageCd.IWF0003));
        return res;
    }

    private void setExtParams(WT_KouteiSummary summary,Map<String, String> rirekimap){

        rirekimap.put(MapKey.sS_EXTPARAM1   , summary.getExtParam1());
        rirekimap.put(MapKey.sS_EXTPARAM2   , summary.getExtParam2());
        rirekimap.put(MapKey.sS_EXTPARAM3   , summary.getExtParam3());
        rirekimap.put(MapKey.sS_EXTPARAM4   , summary.getExtParam4());
        rirekimap.put(MapKey.sS_EXTPARAM5   , summary.getExtParam5());
        rirekimap.put(MapKey.sS_EXTPARAM6   , summary.getExtParam6());
        rirekimap.put(MapKey.sS_EXTPARAM7   , summary.getExtParam7());
        rirekimap.put(MapKey.sS_EXTPARAM8   , summary.getExtParam8());
        rirekimap.put(MapKey.sS_EXTPARAM9   , summary.getExtParam9());
        rirekimap.put(MapKey.sS_EXTPARAM10  , summary.getExtParam10());
        rirekimap.put(MapKey.sS_EXTPARAM11  , summary.getExtParam11());
        rirekimap.put(MapKey.sS_EXTPARAM12  , summary.getExtParam12());
        rirekimap.put(MapKey.sS_EXTPARAM13  , summary.getExtParam13());
        rirekimap.put(MapKey.sS_EXTPARAM14  , summary.getExtParam14());
        rirekimap.put(MapKey.sS_EXTPARAM15  , summary.getExtParam15());
        rirekimap.put(MapKey.sS_EXTPARAM16  , summary.getExtParam16());
        rirekimap.put(MapKey.sS_EXTPARAM17  , summary.getExtParam17());
        rirekimap.put(MapKey.sS_EXTPARAM18  , summary.getExtParam18());
        rirekimap.put(MapKey.sS_EXTPARAM19  , summary.getExtParam19());
        rirekimap.put(MapKey.sS_EXTPARAM20  , summary.getExtParam20());
        rirekimap.put(MapKey.sS_EXTPARAM21  , summary.getExtParam21());
        rirekimap.put(MapKey.sS_EXTPARAM22  , summary.getExtParam22());
        rirekimap.put(MapKey.sS_EXTPARAM23  , summary.getExtParam23());
        rirekimap.put(MapKey.sS_EXTPARAM24  , summary.getExtParam24());
        rirekimap.put(MapKey.sS_EXTPARAM25  , summary.getExtParam25());
        rirekimap.put(MapKey.sS_EXTPARAM26  , summary.getExtParam26());
        rirekimap.put(MapKey.sS_EXTPARAM27  , summary.getExtParam27());
        rirekimap.put(MapKey.sS_EXTPARAM28  , summary.getExtParam28());
        rirekimap.put(MapKey.sS_EXTPARAM29  , summary.getExtParam29());
        rirekimap.put(MapKey.sS_EXTPARAM30  , summary.getExtParam30());
    }

    @Override
    public String execTest() throws Exception {

        WSGetKouteiRirekiSummaryRequest request = new WSGetKouteiRirekiSummaryRequest();

        request.setRequestid("");
        request.setGyoumukey("");
        request.setGyoumukeys(new String[] {"", ""});
        request.setFlowid("");
        request.setFlowids(new String[] {"", ""});
        request.setKouteikaisibifrom("");
        request.setKouteikaisibito("");
        request.setKouteikanryoubifrom("");
        request.setKouteikanryoubito("");
        request.setLastsyoritimefrom("");
        request.setLastsyoritimeto("");
        request.setSyoristatus(new String[] {"", ""});
        request.setAccountid("");
        request.setNodename("");
        request.setAccountwariateumu("");
        request.setKekkajyougenkensu("1000");

        WSGetKouteiRirekiSummaryResponse response = executeBizMain(request);

        return "テスト成功" + response;
    }
}
