package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getkouteirirekisummary;

/**
 * 工程履歴サマリ取得サービスのIOキーです。
 */
public interface IWSGetKouteiRirekiSummaryIOKey {

    interface IN {
        public static final String sS_FLOWID= "flowid";
        public static final String sS_FLOWIDS= "flowids";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_GYOUMUKEYS= "gyoumukeys";
        public static final String sS_LAST_SYORITIME_FROM= "lastsyoritimefrom";
        public static final String sS_LAST_SYORITIME_TO= "lastsyoritimeto";
        public static final String sS_KOUTEI_KAISIBI_FROM= "kouteikaisibifrom";
        public static final String sS_KOUTEI_KAISIBI_TO= "kouteikaisibito";
        public static final String sS_KOUTEI_KANRYOUBI_FROM= "kouteikanryoubifrom";
        public static final String sS_KOUTEI_KANRYOUBI_TO= "kouteikanryoubito";
        public static final String sS_SYORI_STATUS= "syoristatus";
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_NODENAME= "nodename";
        public static final String sS_ACCOUNTWARIATEUMU= "accountwariateumu";
        public static final String sS_KEKKA_JYOUGEN_KENSU= "kekkajyougenkensu";

    }

    interface OUT {
        public static final String sO_RIREKIMAPS= "rirekimaps";

    }

    interface MapKey{

        public static final String sS_FLOWID= "flowid";
        public static final String sS_GYOUMUKEY= "gyoumukey";
        public static final String sS_KOUTEI_KAISIBI= "kouteikaisibi";
        public static final String sS_KOUTEI_KANRYOUBI= "kouteikanryoubi";
        public static final String sS_SYORI_STATUS= "syoristatus";
        public static final String sS_LAST_UPDATE= "lastupdate";
        public static final String sS_FIRST_ACCOUNTID= "firstaccountid";
        public static final String sS_ACCOUNTID= "accountid";
        public static final String sS_NODENAME= "nodename";
        public static final String sS_NODELOCALNAME= "nodelocalname";
        public static final String sS_PREVIOUS_ACCOUNTID= "preaccountid";
        public static final String sS_PREVIOUS_NODENAME= "prenodename";
        public static final String sS_PREVIOUS_NODELOCALNAME= "prenodelocalname";
        public static final String sS_LOCK_UMU = "lockumu";
        public static final String sS_EXTPARAM1 = "extparam1";
        public static final String sS_EXTPARAM2 = "extparam2";
        public static final String sS_EXTPARAM3 = "extparam3";
        public static final String sS_EXTPARAM4 = "extparam4";
        public static final String sS_EXTPARAM5 = "extparam5";
        public static final String sS_EXTPARAM6 = "extparam6";
        public static final String sS_EXTPARAM7 = "extparam7";
        public static final String sS_EXTPARAM8 = "extparam8";
        public static final String sS_EXTPARAM9 = "extparam9";
        public static final String sS_EXTPARAM10 = "extparam10";
        public static final String sS_EXTPARAM11 = "extparam11";
        public static final String sS_EXTPARAM12 = "extparam12";
        public static final String sS_EXTPARAM13 = "extparam13";
        public static final String sS_EXTPARAM14 = "extparam14";
        public static final String sS_EXTPARAM15 = "extparam15";
        public static final String sS_EXTPARAM16 = "extparam16";
        public static final String sS_EXTPARAM17 = "extparam17";
        public static final String sS_EXTPARAM18 = "extparam18";
        public static final String sS_EXTPARAM19 = "extparam19";
        public static final String sS_EXTPARAM20 = "extparam20";
        public static final String sS_EXTPARAM21 = "extparam21";
        public static final String sS_EXTPARAM22 = "extparam22";
        public static final String sS_EXTPARAM23 = "extparam23";
        public static final String sS_EXTPARAM24 = "extparam24";
        public static final String sS_EXTPARAM25 = "extparam25";
        public static final String sS_EXTPARAM26 = "extparam26";
        public static final String sS_EXTPARAM27 = "extparam27";
        public static final String sS_EXTPARAM28 = "extparam28";
        public static final String sS_EXTPARAM29 = "extparam29";
        public static final String sS_EXTPARAM30 = "extparam30";
    }

    interface AccountWariateUmu {

        public static final String sS_ARI= "0";
        public static final String sS_NASI= "1";

    }
}
