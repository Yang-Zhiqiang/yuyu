package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDateYM;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDateYm;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.BM_Simekiribi;
import yuyu.def.db.mapping.GenBM_Simekiribi;
import yuyu.def.db.meta.GenQBM_Simekiribi;
import yuyu.def.db.meta.QBM_Simekiribi;

/**
 * 締切日マスタ のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BM_Simekiribi}</td><td colspan="3">締切日マスタ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBosyuuym bosyuuym}</td><td>募集年月</td><td align="center">○</td><td align="center">V</td><td>BizDateYM</td></tr>
 *  <tr><td>mossimefromymd</td><td>申込締切日自</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mossimetoymd</td><td>申込締切日至</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mosnrksimefromymd</td><td>申込書入力締切日自</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>mosnrksimetoymd</td><td>申込書入力締切日至</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kktsimefromymd</td><td>告知締切日自</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kktsimetoymd</td><td>告知締切日至</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hjysimefromymd</td><td>報状締切日自</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hjysimetoymd</td><td>報状締切日至</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyknsimefromymd</td><td>入金締切日自</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>nyknsimetoymd</td><td>入金締切日至</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syorisimefromymd</td><td>処理締切日自</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>syorisimetoymd</td><td>処理締切日至</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     BM_Simekiribi
 * @see     GenBM_Simekiribi
 * @see     QBM_Simekiribi
 * @see     GenQBM_Simekiribi
 */
public class PKBM_Simekiribi extends AbstractExDBPrimaryKey<BM_Simekiribi, PKBM_Simekiribi> {

    private static final long serialVersionUID = 1L;

    public PKBM_Simekiribi() {
    }

    public PKBM_Simekiribi(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

    @Transient
    @Override
    public Class<BM_Simekiribi> getEntityClass() {
        return BM_Simekiribi.class;
    }

    private BizDateYM bosyuuym;

    @org.hibernate.annotations.Type(type="BizDateYMType")
    public BizDateYM getBosyuuym() {
        return bosyuuym;
    }

    public void setBosyuuym(BizDateYM pBosyuuym) {
        bosyuuym = pBosyuuym;
    }

}