package yuyu.common.workflowcore.core.webservice.provide.imagekanri.putArrivalImage;


public interface WSPutArrivalImage {

    abstract WSPutArrivalImageResponse executeBizMain(WSPutArrivalImageRequest request)
            throws Exception;
}