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
import yuyu.def.db.entity.HW_CreditTrkNgList;
import yuyu.def.db.mapping.GenHW_CreditTrkNgList;
import yuyu.def.db.meta.GenQHW_CreditTrkNgList;
import yuyu.def.db.meta.QHW_CreditTrkNgList;

/**
 * クレジットカード会員登録ＮＧリストワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_CreditTrkNgList}</td><td colspan="3">クレジットカード会員登録ＮＧリストワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditqrerrorcd</td><td>クレジットカードＱＲエラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>bluegateerrorcd</td><td>ＢｌｕｅＧａｔｅエラーコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dbhaneikbn</td><td>ＤＢ反映区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Dbhanei C_Dbhanei}</td></tr>
 *  <tr><td>credittrkhaneierrriyuu</td><td>クレジットカード登録反映エラー理由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_CreditTrkNgList
 * @see     GenHW_CreditTrkNgList
 * @see     QHW_CreditTrkNgList
 * @see     GenQHW_CreditTrkNgList
 */
public class PKHW_CreditTrkNgList extends AbstractExDBPrimaryKey<HW_CreditTrkNgList, PKHW_CreditTrkNgList> {

    private static final long serialVersionUID = 1L;

    public PKHW_CreditTrkNgList() {
    }

    public PKHW_CreditTrkNgList(BizDate pTyouhyouymd, Integer pDatarenno) {
        tyouhyouymd = pTyouhyouymd;
        datarenno = pDatarenno;
    }

    @Transient
    @Override
    public Class<HW_CreditTrkNgList> getEntityClass() {
        return HW_CreditTrkNgList.class;
    }

    private BizDate tyouhyouymd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getTyouhyouymd() {
        return tyouhyouymd;
    }

    public void setTyouhyouymd(BizDate pTyouhyouymd) {
        tyouhyouymd = pTyouhyouymd;
    }
    private Integer datarenno;

    public Integer getDatarenno() {
        return datarenno;
    }

    public void setDatarenno(Integer pDatarenno) {
        datarenno = pDatarenno;
    }

}