package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.MaxLength;
import jp.co.slcs.swak.validation.constraints.SingleByteStrings;
import yuyu.def.db.entity.BM_IkkatuTekiyouNo;
import yuyu.def.db.mapping.GenBM_IkkatuTekiyouNo;
import yuyu.def.db.meta.GenQBM_IkkatuTekiyouNo;
import yuyu.def.db.meta.QBM_IkkatuTekiyouNo;

/**
 * 一括払適用番号マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_IkkatuTekiyouNo}</td><td colspan="3">一括払適用番号マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyouhncd syouhncd}</td><td>商品コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRyouritusdno ryouritusdno}</td><td>料率世代番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ikttekiyouno</td><td>一括払適用番号</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 * </table>
 * @see     BM_IkkatuTekiyouNo
 * @see     GenBM_IkkatuTekiyouNo
 * @see     QBM_IkkatuTekiyouNo
 * @see     GenQBM_IkkatuTekiyouNo
 */
public class PKBM_IkkatuTekiyouNo extends AbstractExDBPrimaryKey<BM_IkkatuTekiyouNo, PKBM_IkkatuTekiyouNo> {

    private static final long serialVersionUID = 1L;

    public PKBM_IkkatuTekiyouNo() {
    }

    public PKBM_IkkatuTekiyouNo(String pSyouhncd, String pRyouritusdno) {
        syouhncd = pSyouhncd;
        ryouritusdno = pRyouritusdno;
    }

    @Transient
    @Override
    public Class<BM_IkkatuTekiyouNo> getEntityClass() {
        return BM_IkkatuTekiyouNo.class;
    }

    private String syouhncd;

    public String getSyouhncd() {
        return syouhncd;
    }

    public void setSyouhncd(String pSyouhncd) {
        syouhncd = pSyouhncd;
    }
    private String ryouritusdno;

    public String getRyouritusdno() {
        return ryouritusdno;
    }

    public void setRyouritusdno(String pRyouritusdno) {
        ryouritusdno = pRyouritusdno;
    }

}