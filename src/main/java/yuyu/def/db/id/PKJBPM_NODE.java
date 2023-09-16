package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JBPM_NODE;
import yuyu.def.db.mapping.GenJBPM_NODE;
import yuyu.def.db.meta.GenQJBPM_NODE;
import yuyu.def.db.meta.QJBPM_NODE;

/**
 * ＪＢＰＭノード のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_NODE}</td><td colspan="3">ＪＢＰＭノード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>class_</td><td>ＪＢＰＭ種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>name_</td><td>ＪＢＰＭ名前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>description_</td><td>ＪＢＰＭ説明</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>processDefinition_</td><td>ＪＢＰＭプロセス定義</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>isAsync_</td><td>ＪＢＰＭ非同期可否</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>isAsyncExcl_</td><td>ＪＢＰＭ非同期排他フラグ</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>action_</td><td>ＪＢＰＭアクション</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>superState_</td><td>ＪＢＰＭスーパー状態</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>subProcName_</td><td>ＪＢＰＭサブプロセス名前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>subProcessDefinition_</td><td>ＪＢＰＭサブプロセス定義</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>decisionExpression_</td><td>ＪＢＰＭデシジョン表現</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>decisionDelegation</td><td>ＪＢＰＭデシジョン委任</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>script_</td><td>ＪＢＰＭスクリプト</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>signal_</td><td>ＪＢＰＭシグナル</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>createTasks_</td><td>ＪＢＰＭタスク生成有無</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>endTasks_</td><td>ＪＢＰＭタスク終了有無</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>nodeCollectionIndex_</td><td>ＪＢＰＭノード集合インデックス</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_NODE
 * @see     GenJBPM_NODE
 * @see     QJBPM_NODE
 * @see     GenQJBPM_NODE
 */
public class PKJBPM_NODE extends AbstractExDBPrimaryKey<JBPM_NODE, PKJBPM_NODE> {

    private static final long serialVersionUID = 1L;

    public PKJBPM_NODE() {
    }

    public PKJBPM_NODE(Long pId) {
        id_ = pId;
    }

    @Transient
    @Override
    public Class<JBPM_NODE> getEntityClass() {
        return JBPM_NODE.class;
    }

    private Long id_;

    public Long getId_() {
        return id_;
    }

    public void setId_(Long pId) {
        id_ = pId;
    }

}