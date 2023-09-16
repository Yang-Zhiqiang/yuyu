package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateY;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.IT_SeisanDHaneiTuuti;
import yuyu.def.db.mapping.GenIT_SeisanDHaneiTuuti;
import yuyu.def.db.meta.GenQIT_SeisanDHaneiTuuti;
import yuyu.def.db.meta.QIT_SeisanDHaneiTuuti;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * 精算Ｄ反映通知テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_SeisanDHaneiTuuti}</td><td colspan="3">精算Ｄ反映通知テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getHaitounendo haitounendo}</td><td>配当年度</td><td align="center">○</td><td align="center">V</td><td>BizDateY</td></tr>
 *  <tr><td>kakuteitounendod</td><td>確定当年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>naiteitounendod</td><td>内定当年度Ｄ</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>seisandkgk</td><td>精算Ｄ金額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_SeisanDHaneiTuuti
 * @see     GenIT_SeisanDHaneiTuuti
 * @see     QIT_SeisanDHaneiTuuti
 * @see     GenQIT_SeisanDHaneiTuuti
 */
public class PKIT_SeisanDHaneiTuuti extends AbstractExDBPrimaryKey<IT_SeisanDHaneiTuuti, PKIT_SeisanDHaneiTuuti> {

    private static final long serialVersionUID = 1L;

    public PKIT_SeisanDHaneiTuuti() {
    }

    public PKIT_SeisanDHaneiTuuti(
        String pKbnkey,
        String pSyono,
        BizDateY pHaitounendo
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        haitounendo = pHaitounendo;
    }

    @Transient
    @Override
    public Class<IT_SeisanDHaneiTuuti> getEntityClass() {
        return IT_SeisanDHaneiTuuti.class;
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
    private BizDateY haitounendo;

    @org.hibernate.annotations.Type(type="BizDateYType")
    public BizDateY getHaitounendo() {
        return haitounendo;
    }

    public void setHaitounendo(BizDateY pHaitounendo) {
        haitounendo = pHaitounendo;
    }

}