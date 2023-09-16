package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.ValidDate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.HT_YuukoukknKykList;
import yuyu.def.db.mapping.GenHT_YuukoukknKykList;
import yuyu.def.db.meta.GenQHT_YuukoukknKykList;
import yuyu.def.db.meta.QHT_YuukoukknKykList;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 有効期間経過契約リストテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_YuukoukknKykList}</td><td colspan="3">有効期間経過契約リストテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>daimosno</td><td>代表申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>hhknnmkj</td><td>被保険者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kyknmkj</td><td>契約者名（漢字）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syusyouhncd</td><td>主契約商品コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syusyouhnnm</td><td>主契約商品名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dntcd</td><td>団体コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dntnm</td><td>団体名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>mosymd</td><td>申込日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>ssyukeymd</td><td>支社受付日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kktkktymd</td><td>告知書告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>hjkktymd</td><td>報状告知日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>kthhbkbn</td><td>決定保留不備区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>srhhbkbn</td><td>成立保留不備区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>jimusrhkbn</td><td>事務成立保留区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_JimusrhKbn C_JimusrhKbn}</td></tr>
 *  <tr><td>syssrhkbn</td><td>システム成立保留区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyssrhKbn C_SyssrhKbn}</td></tr>
 *  <tr><td>khnhbkbn</td><td>基本不備区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 *  <tr><td>ketteikbn</td><td>決定状態区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KetteiKbn C_KetteiKbn}</td></tr>
 *  <tr><td>rfstphrkkeiro</td><td>（帳票用）初回保険料払込経路</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fstphrkkeirokbn</td><td>初回保険料払込経路区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FstphrkkeiroKbn C_FstphrkkeiroKbn}</td></tr>
 *  <tr><td>keikakbn</td><td>経過区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KeikaKbn C_KeikaKbn}</td></tr>
 *  <tr><td>fstnyknrsymd</td><td>初回入金領収日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_YuukoukknKykList
 * @see     GenHT_YuukoukknKykList
 * @see     QHT_YuukoukknKykList
 * @see     GenQHT_YuukoukknKykList
 */
public class PKHT_YuukoukknKykList extends AbstractExDBPrimaryKey<HT_YuukoukknKykList, PKHT_YuukoukknKykList> {

    private static final long serialVersionUID = 1L;

    public PKHT_YuukoukknKykList() {
    }

    public PKHT_YuukoukknKykList(String pMosno, BizDate pTyouhyouymd) {
        mosno = pMosno;
        tyouhyouymd = pTyouhyouymd;
    }

    @Transient
    @Override
    public Class<HT_YuukoukknKykList> getEntityClass() {
        return HT_YuukoukknKykList.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }

}