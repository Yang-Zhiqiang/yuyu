package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_KyuuhuKbn;
import yuyu.def.db.entity.JT_SkKkn;
import yuyu.def.db.mapping.GenJT_SkKkn;
import yuyu.def.db.meta.GenQJT_SkKkn;
import yuyu.def.db.meta.QJT_SkKkn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 請求期間テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SkKkn}</td><td colspan="3">請求期間テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUketukeno uketukeno}</td><td>受付番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyuuhukbn kyuuhukbn}</td><td>給付区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KyuuhuKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kikanfrom</td><td>期間自</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kikanto</td><td>期間至</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syujyututourokuno</td><td>手術登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjcd1</td><td>Ｋ・Ｊコード１</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjcd2</td><td>Ｋ・Ｊコード２</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kjcd3</td><td>Ｋ・Ｊコード３</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syujyutunmkn</td><td>手術名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syujyutunmkj</td><td>手術名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jyouken</td><td>条件</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syujyutubunruicd</td><td>手術分類コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syujyutuhousiki</td><td>手術方式</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyujyutuHousiki C_SyujyutuHousiki}</td></tr>
 *  <tr><td>sensingijuturyou</td><td>先進医療技術料</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>sensinitijikinshrumukbn</td><td>先進医療一時金支払有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SensinItijikinShrUmuKbn C_SensinItijikinShrUmuKbn}</td></tr>
 *  <tr><td>sandaisippeihknshrriyuukbn</td><td>３大疾病保険金支払理由区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_3daiSippeiHknShrRiyuuKbn C_3daiSippeiHknShrRiyuuKbn}</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SkKkn
 * @see     GenJT_SkKkn
 * @see     QJT_SkKkn
 * @see     GenQJT_SkKkn
 */
public class PKJT_SkKkn extends AbstractExDBPrimaryKey<JT_SkKkn, PKJT_SkKkn> {

    private static final long serialVersionUID = 1L;

    public PKJT_SkKkn() {
    }

    public PKJT_SkKkn(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pUketukeno,
        C_KyuuhuKbn pKyuuhukbn,
        Integer pRenno
    ) {
        skno = pSkno;
        syono = pSyono;
        seikyuurirekino = pSeikyuurirekino;
        uketukeno = pUketukeno;
        kyuuhukbn = pKyuuhukbn;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<JT_SkKkn> getEntityClass() {
        return JT_SkKkn.class;
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
    private Integer uketukeno;

    public Integer getUketukeno() {
        return uketukeno;
    }

    public void setUketukeno(Integer pUketukeno) {
        uketukeno = pUketukeno;
    }
    private C_KyuuhuKbn kyuuhukbn;

    @org.hibernate.annotations.Type(type="UserType_C_KyuuhuKbn")
    public C_KyuuhuKbn getKyuuhukbn() {
        return kyuuhukbn;
    }

    public void setKyuuhukbn(C_KyuuhuKbn pKyuuhukbn) {
        kyuuhukbn = pKyuuhukbn;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}