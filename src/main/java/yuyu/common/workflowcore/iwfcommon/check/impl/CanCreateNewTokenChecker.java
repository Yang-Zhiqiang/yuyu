package yuyu.common.workflowcore.iwfcommon.check.impl;

import yuyu.common.workflowcore.api.api.IWorkflowContext;
import yuyu.common.workflowcore.core.webservice.provide.common.logic.IwfCommonLogic.Tokens;
import yuyu.common.workflowcore.iwfcommon.check.Checker;
import yuyu.def.workflowcore.manager.IwfCoreDomManager;

/**
 * トークン作成可否チェッカーです。<br/>
 */
public class CanCreateNewTokenChecker implements Checker<CanCreateNewTokenCheckerInBean>{

    private static final CanCreateNewTokenChecker INSTANCE = new CanCreateNewTokenChecker();

    private CanCreateNewTokenChecker(){
    }

    public static CanCreateNewTokenChecker getInstance(){
        return INSTANCE;
    }

    /**
     * トークン作成の可否をチェックします。<br/>
     * <p>
     * ■チェック仕様<br/>
     * 　チェックテーブルに従ったチェックを行う<br/>
     * <br/>
     * ■チェックテーブル<br/>
     * <table border="1" cellspacing="0" cellpadding="1">
     * <tr>
     *   <td rowspan="2" colspan="2">　</td>
     *   <td colspan="2">業務テーブルに存在</td>
     * </tr>
     * <tr>
     *   <td>する</td>
     *   <td>しない</td>
     * </tr>
     * <tr>
     *   <td rowspan="2">jBPMに存在する</td>
     *   <td>トークン有効</td>
     *   <td>同じ業務キーが存在とみなし、<font color="red">エラー</font>扱い。</td>
     *   <td rowspan="2">ありえない。<br/>存在する場合、<font color="red">エラー</font>扱い。</td>
     * </tr>
     * <tr>
     *   <td>トークン無効</td>
     *   <td>既に中断済みとみなし、<font color="blue">正常</font>扱い。</td>
     * </tr>
     * <tr>
     *   <td colspan="2">jBPMに存在しない</td>
     *   <td>ありえないが、存在する場合、<br/>既に中断済みとみなし、<font color="blue">正常</font>扱い。</td>
     *   <td >通常ケース、<font color="blue">正常</font>扱い。</td>
     * </tr>
     * </table>
     * </p>
     */
    @Override
    public Boolean check(CanCreateNewTokenCheckerInBean... conditions) {

        /*
         * ■チェック条件
         * ┌───┬─────────────────────┐
         * │　　　│　業務キーテーブルに存在　　　　　　　　　│
         * │　　　├───────────┬─────────┤
         * │　　　│する　　　　　　　　　│しない　　　　　　│
         * ├─┬─┼─┬─────────┼─────────┤
         * │　│　│有│同じ業務キーが存在│ありえない　　　　│
         * │　│　│効│とみなし、エラー　│存在する場合、　　│
         * │ｊ│す│　│　　　　　　　　　│エラー扱いとする　│
         * │Ｂ│る├─┼─────────┤　　　　　　　　　│
         * │Ｐ│　│無│既に中断済みとみな│　　　　　　　　　│
         * │Ｍ│　│効│し、正常に登録する│　　　　　　　　　│
         * │に│　│　│　　　　　　　　　│　　　　　　　　　│
         * │存├─┴─┼─────────┼─────────┤
         * │在│　し　│ありえない。が存在│通常ケース　　　　│
         * │　│　な　│する場合、既に中断│正常に登録する。　│
         * │　│　い　│済みとみなし、正常│　　　　　　　　　│
         * │　│　　　│に登録する　　　　│　　　　　　　　　│
         * └─┴───┴─────────┴─────────┘
         */
        IwfCoreDomManager iwfCoreDomManager = conditions[0].getIwfCoreDomManager();
        IWorkflowContext oWfCtx = conditions[0].getWorkflowContext();
        String sGyoumuKey       = conditions[0].getGyoumuKey();
        String sFlowId          = conditions[0].getFlowId();
        String sRequestId       = conditions[0].getRequestId();

        if(Tokens.exists(iwfCoreDomManager, oWfCtx, sGyoumuKey, sFlowId)){

            if(!Tokens.isActive(iwfCoreDomManager, oWfCtx, sGyoumuKey, sFlowId)){

                if(sRequestId == null){
                }else{
                }
                return true;
            }
            else{
                if(sRequestId == null){
                }else{
                }
                return false;
            }
        }
        return true;
    }
}
