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
import yuyu.def.classification.C_SikinidoulistKbn;
import yuyu.def.db.entity.BT_SikinIdouListCsvFSks;
import yuyu.def.db.mapping.GenBT_SikinIdouListCsvFSks;
import yuyu.def.db.meta.GenQBT_SikinIdouListCsvFSks;
import yuyu.def.db.meta.QBT_SikinIdouListCsvFSks;

/**
 * 資金移動リストＣＳＶファイル作成用テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link BT_SikinIdouListCsvFSks}</td><td colspan="3">資金移動リストＣＳＶファイル作成用テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyoriYmd syoriYmd}</td><td>処理年月日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSikinidoulistkbn sikinidoulistkbn}</td><td>資金移動リスト区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_SikinidoulistKbn}</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>sikinidouymd</td><td>資金移動日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>sikinidoumeisaigk</td><td>資金移動明細額</td><td>&nbsp;</td><td align="center">N</td><td>BizCurrency</td></tr>
 *  <tr><td>syukkinkouzatuukasyu</td><td>出金口座通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>syukkinkouzano</td><td>出金口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>nyuukinkouzatuukasyu</td><td>入金口座通貨種類</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_Tuukasyu C_Tuukasyu}</td></tr>
 *  <tr><td>nyuukinkouzano</td><td>入金口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>filesakuseiymd</td><td>ファイル作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 * </table>
 * @see     BT_SikinIdouListCsvFSks
 * @see     GenBT_SikinIdouListCsvFSks
 * @see     QBT_SikinIdouListCsvFSks
 * @see     GenQBT_SikinIdouListCsvFSks
 */
public class PKBT_SikinIdouListCsvFSks extends AbstractExDBPrimaryKey<BT_SikinIdouListCsvFSks, PKBT_SikinIdouListCsvFSks> {

    private static final long serialVersionUID = 1L;

    public PKBT_SikinIdouListCsvFSks() {
    }

    public PKBT_SikinIdouListCsvFSks(
        BizDate pSyoriYmd,
        C_SikinidoulistKbn pSikinidoulistkbn,
        Integer pRenno
    ) {
        syoriYmd = pSyoriYmd;
        sikinidoulistkbn = pSikinidoulistkbn;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<BT_SikinIdouListCsvFSks> getEntityClass() {
        return BT_SikinIdouListCsvFSks.class;
    }

    private BizDate syoriYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getSyoriYmd() {
        return syoriYmd;
    }

    public void setSyoriYmd(BizDate pSyoriYmd) {
        syoriYmd = pSyoriYmd;
    }
    private C_SikinidoulistKbn sikinidoulistkbn;

    @org.hibernate.annotations.Type(type="UserType_C_SikinidoulistKbn")
    public C_SikinidoulistKbn getSikinidoulistkbn() {
        return sikinidoulistkbn;
    }

    public void setSikinidoulistkbn(C_SikinidoulistKbn pSikinidoulistkbn) {
        sikinidoulistkbn = pSikinidoulistkbn;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}