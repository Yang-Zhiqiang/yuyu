package yuyu.common.workflowcore.core.webservice.provide.imagekanri.getqrcodeimages;

public interface IWSGetQrCodeImagesIOKey {

    interface IN {
        public static final String sS_GYOUMUKEYSS= "gyoumukeys";
        public static final String sS_SYORUICDSS= "syoruicds";
    }

    interface OUT {
        public static final String sS_IMGIDSS= "imgids";
        public static final String sO_QRIMGBINARIES= "qrimgbinaries";
    }
}
