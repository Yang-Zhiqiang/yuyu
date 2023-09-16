package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_UketorikouzasyubetuKbn;
import yuyu.def.db.entity.HT_UketoriKouzaJyouhou;
import yuyu.def.db.mapping.GenHT_UketoriKouzaJyouhou;
import yuyu.def.db.meta.GenQHT_UketoriKouzaJyouhou;
import yuyu.def.db.meta.QHT_UketoriKouzaJyouhou;
import yuyu.infr.validation.constraints.MousikomiNo;

/**
 * 受取口座情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link HT_UketoriKouzaJyouhou}</td><td colspan="3">受取口座情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getMosno mosno}</td><td>申込番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getUktkzsyubetukbn uktkzsyubetukbn}</td><td>受取口座種別区分</td><td align="center">○</td><td align="center">V</td><td>{@link C_UketorikouzasyubetuKbn}</td></tr>
 *  <tr><td>kouzainfoinputhoryuukbn</td><td>口座情報入力保留区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KouzaInfoInputHoryuuKbn C_KouzaInfoInputHoryuuKbn}</td></tr>
 *  <tr><td>kzsyuruikbn</td><td>口座種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KouzasyuruiKbn C_KouzasyuruiKbn}</td></tr>
 *  <tr><td>bankcd</td><td>銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>sitencd</td><td>支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>yokinkbn</td><td>預金種目区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_YokinKbn C_YokinKbn}</td></tr>
 *  <tr><td>kouzano</td><td>口座番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>kzkykdoukbn</td><td>口座名義契約者同一人区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_KzkykdouKbn C_KzkykdouKbn}</td></tr>
 *  <tr><td>kzmeiginmkn</td><td>口座名義人氏名（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     HT_UketoriKouzaJyouhou
 * @see     GenHT_UketoriKouzaJyouhou
 * @see     QHT_UketoriKouzaJyouhou
 * @see     GenQHT_UketoriKouzaJyouhou
 */
public class PKHT_UketoriKouzaJyouhou extends AbstractExDBPrimaryKey<HT_UketoriKouzaJyouhou, PKHT_UketoriKouzaJyouhou> {

    private static final long serialVersionUID = 1L;

    public PKHT_UketoriKouzaJyouhou() {
    }

    public PKHT_UketoriKouzaJyouhou(String pMosno, C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {
        mosno = pMosno;
        uktkzsyubetukbn = pUktkzsyubetukbn;
    }

    @Transient
    @Override
    public Class<HT_UketoriKouzaJyouhou> getEntityClass() {
        return HT_UketoriKouzaJyouhou.class;
    }

    private String mosno;

    public String getMosno() {
        return mosno;
    }

    public void setMosno(String pMosno) {
        mosno = pMosno;
    }
    private C_UketorikouzasyubetuKbn uktkzsyubetukbn;

    @org.hibernate.annotations.Type(type="UserType_C_UketorikouzasyubetuKbn")
    public C_UketorikouzasyubetuKbn getUktkzsyubetukbn() {
        return uktkzsyubetukbn;
    }

    public void setUktkzsyubetukbn(C_UketorikouzasyubetuKbn pUktkzsyubetukbn) {
        uktkzsyubetukbn = pUktkzsyubetukbn;
    }

}