package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JBPM_TASK;
import yuyu.def.db.mapping.GenJBPM_TASK;
import yuyu.def.db.meta.GenQJBPM_TASK;
import yuyu.def.db.meta.QJBPM_TASK;

/**
 * ＪＢＰＭタスク のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_TASK}</td><td colspan="3">ＪＢＰＭタスク</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>name_</td><td>ＪＢＰＭ名前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>description_</td><td>ＪＢＰＭ説明</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>processDefinition_</td><td>ＪＢＰＭプロセス定義</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>isBlocking_</td><td>ＪＢＰＭブロックフラグ</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>isSignalling_</td><td>ＪＢＰＭトークン駆動可否</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>condition_</td><td>ＪＢＰＭ状況</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dueDate_</td><td>ＪＢＰＭ期限日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>priority_</td><td>ＪＢＰＭ優先度</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>actorIdExpression_</td><td>ＪＢＰＭタスクＩＤ表現</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>pooledActorsExpression_</td><td>ＪＢＰＭプールアクター表現</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>taskMgmtDefinition_</td><td>ＪＢＰＭタスク管理定義</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>taskNode_</td><td>ＪＢＰＭタスクノード</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>startState_</td><td>ＪＢＰＭ開始状態</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>assignmentDelegation_</td><td>ＪＢＰＭ割当委任</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>swimlane_</td><td>ＪＢＰＭタスクレーン</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>taskController_</td><td>ＪＢＰＭタスクコントローラ</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_TASK
 * @see     GenJBPM_TASK
 * @see     QJBPM_TASK
 * @see     GenQJBPM_TASK
 */
public class PKJBPM_TASK extends AbstractExDBPrimaryKey<JBPM_TASK, PKJBPM_TASK> {

    private static final long serialVersionUID = 1L;

    public PKJBPM_TASK() {
    }

    public PKJBPM_TASK(Long pId) {
        id_ = pId;
    }

    @Transient
    @Override
    public Class<JBPM_TASK> getEntityClass() {
        return JBPM_TASK.class;
    }

    private Long id_;

    public Long getId_() {
        return id_;
    }

    public void setId_(Long pId) {
        id_ = pId;
    }

}