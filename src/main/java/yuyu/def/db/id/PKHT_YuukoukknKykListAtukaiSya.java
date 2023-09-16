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
import yuyu.def.classification.C_KeikaKbn;
import yuyu.def.db.entity.HT_YuukoukknKykListAtukaiSya;
import yuyu.def.db.mapping.GenHT_YuukoukknKykListAtukaiSya;
import yuyu.def.db.meta.GenQHT_YuukoukknKykListAtukaiSya;
import yuyu.def.db.meta.QHT_YuukoukknKykListAtukaiSya;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 有効期間経過契約リスト扱者テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_YuukoukknKykListAtukaiSya}</td><td colspan="3">有効期間経過契約リスト扱者テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getKeikakbn keikakbn}</td><td>経過区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_KeikaKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>kinyuucd</td><td>金融機関コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kinyuusitencd</td><td>金融機関支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtencd</td><td>代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>drtennm</td><td>代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tratkiagcd</td><td>取扱代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>tratkiagnm</td><td>取扱代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtencd</td><td>親代理店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>oyadrtennm</td><td>親代理店名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimusyocd</td><td>事務所コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuucd</td><td>募集人コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuutrkno</td><td>募集人登録番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bosyuunm</td><td>募集人名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_YuukoukknKykListAtukaiSya
 * @see     GenHT_YuukoukknKykListAtukaiSya
 * @see     QHT_YuukoukknKykListAtukaiSya
 * @see     GenQHT_YuukoukknKykListAtukaiSya
 */
public class PKHT_YuukoukknKykListAtukaiSya extends AbstractExDBPrimaryKey<HT_YuukoukknKykListAtukaiSya, PKHT_YuukoukknKykListAtukaiSya> {

    private static final long serialVersionUID = 1L;

    public PKHT_YuukoukknKykListAtukaiSya() {
    }

    public PKHT_YuukoukknKykListAtukaiSya(
        String pMosno,
        BizDate pTyouhyouymd,
        C_KeikaKbn pKeikakbn,
        Integer pRenno
    ) {
        mosno = pMosno;
        tyouhyouymd = pTyouhyouymd;
        keikakbn = pKeikakbn;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<HT_YuukoukknKykListAtukaiSya> getEntityClass() {
        return HT_YuukoukknKykListAtukaiSya.class;
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
    private C_KeikaKbn keikakbn;

    @org.hibernate.annotations.Type(type="UserType_C_KeikaKbn")
    public C_KeikaKbn getKeikakbn() {
        return keikakbn;
    }

    public void setKeikakbn(C_KeikaKbn pKeikakbn) {
        keikakbn = pKeikakbn;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}