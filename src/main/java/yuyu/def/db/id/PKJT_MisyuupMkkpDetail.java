package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_MisyuupMkkpDetail;
import yuyu.def.db.mapping.GenJT_MisyuupMkkpDetail;
import yuyu.def.db.meta.GenQJT_MisyuupMkkpDetail;
import yuyu.def.db.meta.QJT_MisyuupMkkpDetail;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 未収Ｐ未経過Ｐ明細テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_MisyuupMkkpDetail}</td><td colspan="3">未収Ｐ未経過Ｐ明細テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dtlmisyuup</td><td>明細未収保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dtlmisyuupgaika</td><td>明細未収保険料（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dtlmisyuupgaikayenknsnkngk</td><td>明細未収保険料（外貨）円換算金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dtlmisyuupiktnkumu</td><td>明細未収保険料一括入金有無</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>dtlmisyuuphrkkaisuu</td><td>明細未収保険料払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>dtlmisyuupjtkaisuuy</td><td>明細未収保険料充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dtlmisyuupjtkaisuum</td><td>明細未収保険料充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dtlmisyuupjytym</td><td>明細未収保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>dtlmikeikap</td><td>明細未経過保険料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dtlmikeikapgaika</td><td>明細未経過保険料（外貨）</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>dtlmikeikapnykdenymd</td><td>明細未経過保険料入金伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>dtlmikeikaphrkkaisuu</td><td>明細未経過保険料払込回数</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Hrkkaisuu C_Hrkkaisuu}</td></tr>
 *  <tr><td>dtlmikeikapjtkaisuuy</td><td>明細未経過保険料充当回数（年）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dtlmikeikapjtkaisuum</td><td>明細未経過保険料充当回数（月）</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>dtlmikeikapjytym</td><td>明細未経過保険料充当年月</td><td>&nbsp;</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_MisyuupMkkpDetail
 * @see     GenJT_MisyuupMkkpDetail
 * @see     QJT_MisyuupMkkpDetail
 * @see     GenQJT_MisyuupMkkpDetail
 */
public class PKJT_MisyuupMkkpDetail extends AbstractExDBPrimaryKey<JT_MisyuupMkkpDetail, PKJT_MisyuupMkkpDetail> {

    private static final long serialVersionUID = 1L;

    public PKJT_MisyuupMkkpDetail() {
    }

    public PKJT_MisyuupMkkpDetail(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pDatarenno
    ) {
        skno = pSkno;
        syono = pSyono;
        seikyuurirekino = pSeikyuurirekino;
        datarenno = pDatarenno;
    }

    @Transient
    @Override
    public Class<JT_MisyuupMkkpDetail> getEntityClass() {
        return JT_MisyuupMkkpDetail.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private Integer seikyuurirekino;

    public Integer getSeikyuurirekino() {
        return seikyuurirekino;
    }

    public void setSeikyuurirekino(Integer pSeikyuurirekino) {
        seikyuurirekino = pSeikyuurirekino;
    }
    private Integer datarenno;

    public Integer getDatarenno() {
        return datarenno;
    }

    public void setDatarenno(Integer pDatarenno) {
        datarenno = pDatarenno;
    }

}