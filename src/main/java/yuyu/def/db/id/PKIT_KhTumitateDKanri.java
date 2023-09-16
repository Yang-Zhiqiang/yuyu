package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_KhTumitateDKanri;
import yuyu.def.db.mapping.GenIT_KhTumitateDKanri;
import yuyu.def.db.meta.GenQIT_KhTumitateDKanri;
import yuyu.def.db.meta.QIT_KhTumitateDKanri;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 積立Ｄ管理テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_KhTumitateDKanri}</td><td colspan="3">積立Ｄ管理テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTumitatedtumitateymd tumitatedtumitateymd}</td><td>積立Ｄ積立年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>tumitatedskskbn</td><td>積立Ｄ作成区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_TumitateDSakuseiKbn C_TumitateDSakuseiKbn}</td></tr>
 *  <tr><td>tumitated</td><td>積立Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>tumitatedshrkrkymd</td><td>積立Ｄ支払効力日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>naiteikakuteikbn</td><td>内定確定区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_NaiteiKakuteiKbn C_NaiteiKakuteiKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_KhTumitateDKanri
 * @see     GenIT_KhTumitateDKanri
 * @see     QIT_KhTumitateDKanri
 * @see     GenQIT_KhTumitateDKanri
 */
public class PKIT_KhTumitateDKanri extends AbstractExDBPrimaryKey<IT_KhTumitateDKanri, PKIT_KhTumitateDKanri> {

    private static final long serialVersionUID = 1L;

    public PKIT_KhTumitateDKanri() {
    }

    public PKIT_KhTumitateDKanri(
        String pKbnkey,
        String pSyono,
        BizDate pTumitatedtumitateymd,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        tumitatedtumitateymd = pTumitatedtumitateymd;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_KhTumitateDKanri> getEntityClass() {
        return IT_KhTumitateDKanri.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private BizDate tumitatedtumitateymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTumitatedtumitateymd() {
        return tumitatedtumitateymd;
    }

    public void setTumitatedtumitateymd(BizDate pTumitatedtumitateymd) {
        tumitatedtumitateymd = pTumitatedtumitateymd;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}