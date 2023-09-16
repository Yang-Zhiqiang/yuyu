package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JBPM_PROCESSDEFINITION;
import yuyu.def.db.mapping.GenJBPM_PROCESSDEFINITION;
import yuyu.def.db.meta.GenQJBPM_PROCESSDEFINITION;
import yuyu.def.db.meta.QJBPM_PROCESSDEFINITION;

/**
 * ＪＢＰＭプロセス定義 のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JBPM_PROCESSDEFINITION}</td><td colspan="3">ＪＢＰＭプロセス定義</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getId id_}</td><td>ＪＢＰＭ一意ＩＤ</td><td align="center">○</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>class_</td><td>ＪＢＰＭ種類</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>name_</td><td>ＪＢＰＭ名前</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>description_</td><td>ＪＢＰＭ説明</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>version_</td><td>ＪＢＰＭバージョン</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>isTerminationImplicit_</td><td>ＪＢＰＭ衝突中止フラグ</td><td>&nbsp;</td><td align="center">N</td><td>String</td></tr>
 *  <tr><td>startState_</td><td>ＪＢＰＭ開始状態</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 * </table>
 * @see     JBPM_PROCESSDEFINITION
 * @see     GenJBPM_PROCESSDEFINITION
 * @see     QJBPM_PROCESSDEFINITION
 * @see     GenQJBPM_PROCESSDEFINITION
 */
public class PKJBPM_PROCESSDEFINITION extends AbstractExDBPrimaryKey<JBPM_PROCESSDEFINITION, PKJBPM_PROCESSDEFINITION> {

    private static final long serialVersionUID = 1L;

    public PKJBPM_PROCESSDEFINITION() {
    }

    public PKJBPM_PROCESSDEFINITION(Long pId) {
        id_ = pId;
    }

    @Transient
    @Override
    public Class<JBPM_PROCESSDEFINITION> getEntityClass() {
        return JBPM_PROCESSDEFINITION.class;
    }

    private Long id_;

    public Long getId_() {
        return id_;
    }

    public void setId_(Long pId) {
        id_ = pId;
    }

}