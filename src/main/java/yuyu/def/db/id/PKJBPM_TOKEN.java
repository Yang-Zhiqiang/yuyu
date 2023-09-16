package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JBPM_TOKEN;
import yuyu.def.db.mapping.GenJBPM_TOKEN;
import yuyu.def.db.meta.GenQJBPM_TOKEN;
import yuyu.def.db.meta.QJBPM_TOKEN;

/**
 * ＪＢＰＭトークン のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_TOKEN}</td><td colspan="3">ＪＢＰＭトークン</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>version_</td><td>ＪＢＰＭバージョン</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>name_</td><td>ＪＢＰＭ名前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>start_</td><td>ＪＢＰＭ開始時間</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>end_</td><td>ＪＢＰＭ終了時間</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>nodeEnter_</td><td>ＪＢＰＭノードに入る時間</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>nextLogIndex_</td><td>ＪＢＰＭ次のログインデックス</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>isAbleToReactivateParent_</td><td>ＪＢＰＭ親の再活性化可否</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>isTerminationImplicit_</td><td>ＪＢＰＭ衝突中止フラグ</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>node_</td><td>ＪＢＰＭノード</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>isSuspended_</td><td>ＪＢＰＭ一時中止フラグ</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>lock_</td><td>ＪＢＰＭロック</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>processInstance_</td><td>ＪＢＰＭプロセスインスタンス</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>parent_</td><td>ＪＢＰＭ親トークン</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>subProcessInstance_</td><td>ＪＢＰＭ子プロセスインスタンス</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_TOKEN
 * @see     GenJBPM_TOKEN
 * @see     QJBPM_TOKEN
 * @see     GenQJBPM_TOKEN
 */
public class PKJBPM_TOKEN extends AbstractExDBPrimaryKey<JBPM_TOKEN, PKJBPM_TOKEN> {

    private static final long serialVersionUID = 1L;

    public PKJBPM_TOKEN() {
    }

    public PKJBPM_TOKEN(Long pId) {
        id_ = pId;
    }

    @Transient
    @Override
    public Class<JBPM_TOKEN> getEntityClass() {
        return JBPM_TOKEN.class;
    }

    private Long id_;

    public Long getId_() {
        return id_;
    }

    public void setId_(Long pId) {
        id_ = pId;
    }

}