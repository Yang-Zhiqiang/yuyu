package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JBPM_TASKINSTANCE;
import yuyu.def.db.mapping.GenJBPM_TASKINSTANCE;
import yuyu.def.db.meta.GenQJBPM_TASKINSTANCE;
import yuyu.def.db.meta.QJBPM_TASKINSTANCE;

/**
 * ＪＢＰＭタスクインスタンス のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_TASKINSTANCE}</td><td colspan="3">ＪＢＰＭタスクインスタンス</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>class_</td><td>ＪＢＰＭ種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>version_</td><td>ＪＢＰＭバージョン</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>name_</td><td>ＪＢＰＭ名前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>description_</td><td>ＪＢＰＭ説明</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>actorId_</td><td>ＪＢＰＭアクターＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>create_</td><td>ＪＢＰＭ生成時間</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>start_</td><td>ＪＢＰＭ開始時間</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>end_</td><td>ＪＢＰＭ終了時間</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>dueDate_</td><td>ＪＢＰＭ期限日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>priority_</td><td>ＪＢＰＭ優先度</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>isCancelled_</td><td>ＪＢＰＭキャンセルフラグ</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>isSuspended_</td><td>ＪＢＰＭ一時中止フラグ</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>isOpen_</td><td>ＪＢＰＭ解放フラグ</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>isSignalling_</td><td>ＪＢＰＭトークン駆動可否</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>isBlocking_</td><td>ＪＢＰＭブロックフラグ</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>task_</td><td>ＪＢＰＭタスク</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>token_</td><td>ＪＢＰＭトークン</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>procInst_</td><td>ＪＢＰＭ所属プロセスインスタンス</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>swimlaneInstance_</td><td>ＪＢＰＭレーンインスタンス</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>taskMgmtInstance_</td><td>ＪＢＰＭタスク管理インスタンス</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_TASKINSTANCE
 * @see     GenJBPM_TASKINSTANCE
 * @see     QJBPM_TASKINSTANCE
 * @see     GenQJBPM_TASKINSTANCE
 */
public class PKJBPM_TASKINSTANCE extends AbstractExDBPrimaryKey<JBPM_TASKINSTANCE, PKJBPM_TASKINSTANCE> {

    private static final long serialVersionUID = 1L;

    public PKJBPM_TASKINSTANCE() {
    }

    public PKJBPM_TASKINSTANCE(Long pId) {
        id_ = pId;
    }

    @Transient
    @Override
    public Class<JBPM_TASKINSTANCE> getEntityClass() {
        return JBPM_TASKINSTANCE.class;
    }

    private Long id_;

    public Long getId_() {
        return id_;
    }

    public void setId_(Long pId) {
        id_ = pId;
    }

}