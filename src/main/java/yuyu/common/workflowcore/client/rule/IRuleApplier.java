package yuyu.common.workflowcore.client.rule;

/**
 * ルールインタフェースです。
 */
public interface IRuleApplier<I, O> {

    public O apply(I inBean, O outBean) throws Exception;

}
