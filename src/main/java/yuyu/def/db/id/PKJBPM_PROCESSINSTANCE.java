package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JBPM_PROCESSINSTANCE;
import yuyu.def.db.mapping.GenJBPM_PROCESSINSTANCE;
import yuyu.def.db.meta.GenQJBPM_PROCESSINSTANCE;
import yuyu.def.db.meta.QJBPM_PROCESSINSTANCE;

/**
 * ＪＢＰＭプロセスインスタンス のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_PROCESSINSTANCE}</td><td colspan="3">ＪＢＰＭプロセスインスタンス</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>version_</td><td>ＪＢＰＭバージョン</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>key_</td><td>ＪＢＰＭユニークキー</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>start_</td><td>ＪＢＰＭ開始時間</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>end_</td><td>ＪＢＰＭ終了時間</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>isSuspended_</td><td>ＪＢＰＭ一時中止フラグ</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>processDefinition_</td><td>ＪＢＰＭプロセス定義</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>rootToken_</td><td>ＪＢＰＭルートトークン</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>superProcessToken_</td><td>ＪＢＰＭスーパープロセストークン</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_PROCESSINSTANCE
 * @see     GenJBPM_PROCESSINSTANCE
 * @see     QJBPM_PROCESSINSTANCE
 * @see     GenQJBPM_PROCESSINSTANCE
 */
public class PKJBPM_PROCESSINSTANCE extends AbstractExDBPrimaryKey<JBPM_PROCESSINSTANCE, PKJBPM_PROCESSINSTANCE> {

    private static final long serialVersionUID = 1L;

    public PKJBPM_PROCESSINSTANCE() {
    }

    public PKJBPM_PROCESSINSTANCE(Long pId) {
        id_ = pId;
    }

    @Transient
    @Override
    public Class<JBPM_PROCESSINSTANCE> getEntityClass() {
        return JBPM_PROCESSINSTANCE.class;
    }

    private Long id_;

    public Long getId_() {
        return id_;
    }

    public void setId_(Long pId) {
        id_ = pId;
    }

}