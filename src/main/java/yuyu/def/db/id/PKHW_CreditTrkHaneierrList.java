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
import yuyu.def.db.entity.HW_CreditTrkHaneierrList;
import yuyu.def.db.mapping.GenHW_CreditTrkHaneierrList;
import yuyu.def.db.meta.GenQHW_CreditTrkHaneierrList;
import yuyu.def.db.meta.QHW_CreditTrkHaneierrList;

/**
 * クレジットカード登録反映エラーリストワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HW_CreditTrkHaneierrList}</td><td colspan="3">クレジットカード登録反映エラーリストワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getTyouhyouymd tyouhyouymd}</td><td>帳票作成日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getDatarenno datarenno}</td><td>データ連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>mosno</td><td>申込番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>credittrkhoukbn</td><td>クレジットカード登録方法区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_CreditTrkhouKbn C_CreditTrkhouKbn}</td></tr>
 *  <tr><td>sosikicd</td><td>組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>creditkessaiyouno</td><td>クレジットカード決済用番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>credittrkhaneierrriyuu</td><td>クレジットカード登録反映エラー理由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HW_CreditTrkHaneierrList
 * @see     GenHW_CreditTrkHaneierrList
 * @see     QHW_CreditTrkHaneierrList
 * @see     GenQHW_CreditTrkHaneierrList
 */
public class PKHW_CreditTrkHaneierrList extends AbstractExDBPrimaryKey<HW_CreditTrkHaneierrList, PKHW_CreditTrkHaneierrList> {

    private static final long serialVersionUID = 1L;

    public PKHW_CreditTrkHaneierrList() {
    }

    public PKHW_CreditTrkHaneierrList(BizDate pTyouhyouymd, Integer pDatarenno) {
        tyouhyouymd = pTyouhyouymd;
        datarenno = pDatarenno;
    }

    @Transient
    @Override
    public Class<HW_CreditTrkHaneierrList> getEntityClass() {
        return HW_CreditTrkHaneierrList.class;
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