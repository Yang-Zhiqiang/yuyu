package iwf.callback.arriveimage.imageTerminator;


public interface WSImageTerminator {

    abstract WSImageTerminatorResponse terminate(WSImageTerminatorRequest request) throws Exception;
}