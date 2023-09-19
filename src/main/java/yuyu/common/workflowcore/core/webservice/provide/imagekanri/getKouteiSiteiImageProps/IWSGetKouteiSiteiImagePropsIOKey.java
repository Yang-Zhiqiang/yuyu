package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getKouteiSiteiImageProps;

/**
 * 工程情報指定イメージプロパティ取得サービスのプロバイダークラスです。
 */
public interface IWSGetKouteiSiteiImagePropsIOKey {

    interface IN {
        public static final String sS_FLOWID = "flowid";
        public static final String sS_FLOWIDS = "flowids";
        public static final String sS_GYOUMUKEY = "gyoumukey";
        public static final String sS_GYOUMUKEYS = "gyoumukeys";
        public static final String sS_LAST_SYORITIME_FROM = "lastsyoritimefrom";
        public static final String sS_LAST_SYORITIME_TO = "lastsyoritimeto";
        public static final String sS_KOUTEI_KAISIBI_FROM = "kouteikaisibifrom";
        public static final String sS_KOUTEI_KAISIBI_TO = "kouteikaisibito";
        public static final String sS_KOUTEI_KANRYOUBI_FROM = "kouteikanryoubifrom";
        public static final String sS_KOUTEI_KANRYOUBI_TO = "kouteikanryoubito";
        public static final String sS_SYORI_STATUS = "syoristatus";
        public static final String sS_ACCOUNTID = "accountid";
        public static final String sS_NODENAME = "nodename";
        public static final String sS_ACCOUNTWARIATEUMU = "accountwariateumu";
        public static final String sS_KEKKA_JYOUGEN_KENSU = "kekkajyougenkensu";
        public static final String sS_TORIKOMISYORUICD = "torikomisyoruicd";
        public static final String sS_SYORUITOUTYAKUYMDFROM = "syoruitoutyakuymdfrom";
        public static final String sS_SYORUITOUTYAKUYMDTO = "syoruitoutyakuymdto";
        public static final String sS_TANTOUSYA_ACCOUNTID = "tantousyaaccountid";
    }

    interface OUT {
        public static final String sO_IMAGEPROPSLIST = "imagepropslist";
        public static final String sS_IMAGEID = "imageid";
        public static final String sS_GYOUMUKEY = "gyoumukey";
        public static final String sS_TORIKOMISYORUICD = "torikomisyoruicd";
        public static final String sS_TOUROKUTIME = "tourokutime";
        public static final String sS_SYORUITOUTYAKUTIME = "syoruitoutyakutime";
        public static final String sS_KOUTEIJYOUTAI = "kouteijyoutai";
        public static final String sS_KENGENUMU = "kengenumu";
        public static final String sS_TOUROKUACCOUNTID = "tourokuaccountid";
        public static final String sS_FLOWID = "flowid";
    }

    interface MapKey {
        public static final String sS_FLOWID = "flowid";
        public static final String sS_GYOUMUKEY = "gyoumukey";
        public static final String sS_KOUTEI_KAISIBI = "kouteikaisibi";
        public static final String sS_KOUTEI_KANRYOUBI = "kouteikanryoubi";
        public static final String sS_SYORI_STATUS = "syoristatus";
        public static final String sS_LAST_UPDATE = "lastupdate";
        public static final String sS_FIRST_ACCOUNTID = "firstaccountid";
        public static final String sS_ACCOUNTID = "accountid";
        public static final String sS_NODENAME = "nodename";
        public static final String sS_NODELOCALNAME = "nodelocalname";
        public static final String sS_PREVIOUS_ACCOUNTID = "preaccountid";
        public static final String sS_PREVIOUS_NODENAME = "prenodename";
        public static final String sS_PREVIOUS_NODELOCALNAME = "prenodelocalname";
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
    }

    interface AccountWariateUmu {
        public static final String sS_ARI = "0";
        public static final String sS_NASI = "1";

    }
}
