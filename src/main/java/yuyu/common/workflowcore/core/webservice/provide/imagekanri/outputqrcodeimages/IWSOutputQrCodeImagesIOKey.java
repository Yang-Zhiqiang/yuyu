package yuyu.common.workflowcore.core.webservice.provide.imagekanri.outputqrcodeimages;

public interface IWSOutputQrCodeImagesIOKey {

    interface IN {
        public static final String sS_GYOUMUKEYSS= "gyoumukeys";
        public static final String sS_SYORUICDSS= "syoruicds";
        public static final String sS_OUTPUTPATH= "outputpath";
    }

    interface OUT {
        public static final String sS_IMGIDSS= "imgids";
        public static final String sS_FILENAMESS= "filenames";
    }
}
