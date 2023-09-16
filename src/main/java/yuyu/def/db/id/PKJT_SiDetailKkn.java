package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_SiDetailKkn;
import yuyu.def.db.mapping.GenJT_SiDetailKkn;
import yuyu.def.db.meta.GenQJT_SiDetailKkn;
import yuyu.def.db.meta.QJT_SiDetailKkn;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 支払明細期間テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_SiDetailKkn}</td><td colspan="3">支払明細期間テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSeikyuurirekino seikyuurirekino}</td><td>請求履歴番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUketukeno uketukeno}</td><td>受付番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKyuuhucd kyuuhucd}</td><td>給付コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno2keta2 renno2keta2}</td><td>連番（２桁）２</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>shrtaisyoukbn</td><td>支払対象区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrtaisyouKbn C_ShrtaisyouKbn}</td></tr>
 *  <tr><td>taisyoukknfrom</td><td>対象期間（自）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>taisyoukknto</td><td>対象期間（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seikyuukknfrom</td><td>請求期間（自）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>seikyuukknto</td><td>請求期間（至）</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
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
 *  <tr><td>shrkekkakbn</td><td>支払結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ShrKekkaKbn C_ShrKekkaKbn}</td></tr>
 *  <tr><td>hushrsyousaikbn</td><td>不支払詳細区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HushrSyousaiKbn C_HushrSyousaiKbn}</td></tr>
 *  <tr><td>hutanpoflg</td><td>不担保フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>itinyuuingendotyoukaflg</td><td>1入院限度超過フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tuusangendotyoukaflg</td><td>通算限度超過フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>gannyuuinflg</td><td>がん入院フラグ</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>nyuuintyuuflg</td><td>入院中フラグ</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kyhknskgnkkntaisyouumukbn</td><td>給付金削減期間対象有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>kossyoricd</td><td>更新処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kossyorisscd</td><td>更新処理詳細コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_SiDetailKkn
 * @see     GenJT_SiDetailKkn
 * @see     QJT_SiDetailKkn
 * @see     GenQJT_SiDetailKkn
 */
public class PKJT_SiDetailKkn extends AbstractExDBPrimaryKey<JT_SiDetailKkn, PKJT_SiDetailKkn> {

    private static final long serialVersionUID = 1L;

    public PKJT_SiDetailKkn() {
    }

    public PKJT_SiDetailKkn(
        String pSkno,
        String pSyono,
        Integer pSeikyuurirekino,
        Integer pUketukeno,
        String pKyuuhucd,
        Integer pRenno,
        Integer pRenno2keta2
    ) {
        skno = pSkno;
        syono = pSyono;
        seikyuurirekino = pSeikyuurirekino;
        uketukeno = pUketukeno;
        kyuuhucd = pKyuuhucd;
        renno = pRenno;
        renno2keta2 = pRenno2keta2;
    }

    @Transient
    @Override
    public Class<JT_SiDetailKkn> getEntityClass() {
        return JT_SiDetailKkn.class;
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
    private String kyuuhucd;

    public String getKyuuhucd() {
        return kyuuhucd;
    }

    public void setKyuuhucd(String pKyuuhucd) {
        kyuuhucd = pKyuuhucd;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }
    private Integer renno2keta2;

    public Integer getRenno2keta2() {
        return renno2keta2;
    }

    public void setRenno2keta2(Integer pRenno2keta2) {
        renno2keta2 = pRenno2keta2;
    }

}