package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.AlphaDigit;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import yuyu.def.db.entity.AM_HonyakutsgSosikiCd;
import yuyu.def.db.mapping.GenAM_HonyakutsgSosikiCd;
import yuyu.def.db.meta.GenQAM_HonyakutsgSosikiCd;
import yuyu.def.db.meta.QAM_HonyakutsgSosikiCd;

/**
 * 翻訳対象外組織コードマスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AM_HonyakutsgSosikiCd}</td><td colspan="3">翻訳対象外組織コードマスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSosikicd sosikicd}</td><td>組織コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     AM_HonyakutsgSosikiCd
 * @see     GenAM_HonyakutsgSosikiCd
 * @see     QAM_HonyakutsgSosikiCd
 * @see     GenQAM_HonyakutsgSosikiCd
 */
public class PKAM_HonyakutsgSosikiCd extends AbstractExDBPrimaryKey<AM_HonyakutsgSosikiCd, PKAM_HonyakutsgSosikiCd> {

    private static final long serialVersionUID = 1L;

    public PKAM_HonyakutsgSosikiCd() {
    }

    public PKAM_HonyakutsgSosikiCd(String pSosikicd) {
        sosikicd = pSosikicd;
    }

    @Transient
    @Override
    public Class<AM_HonyakutsgSosikiCd> getEntityClass() {
        return AM_HonyakutsgSosikiCd.class;
    }

    private String sosikicd;

    public String getSosikicd() {
        return sosikicd;
    }

    public void setSosikicd(String pSosikicd) {
        sosikicd = pSosikicd;
    }

}