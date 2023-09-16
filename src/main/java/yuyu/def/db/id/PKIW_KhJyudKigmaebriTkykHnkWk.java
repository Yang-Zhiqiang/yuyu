package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.mapping.GenIW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.meta.GenQIW_KhJyudKigmaebriTkykHnkWk;
import yuyu.def.db.meta.QIW_KhJyudKigmaebriTkykHnkWk;

/**
 * 重度介護前払特約変更ワークテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IW_KhJyudKigmaebriTkykHnkWk}</td><td colspan="3">重度介護前払特約変更ワークテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKouteikanriid kouteikanriid}</td><td>工程管理ＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syono</td><td>証券番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>skssakuseiymd</td><td>請求書作成日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>jyudkaigomaebaraitkykhnkkbn</td><td>重度介護前払特約変更区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_JyudkaigomaebaraiTkykhnkKbn C_JyudkaigomaebaraiTkykhnkKbn}</td></tr>
 *  <tr><td>honninkakninkekkakbn</td><td>本人確認結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HonninKakninKekkaKbn C_HonninKakninKekkaKbn}</td></tr>
 *  <tr><td>hassoukbn</td><td>発送区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_HassouKbn C_HassouKbn}</td></tr>
 *  <tr><td>zenkaisyorikekkakbn</td><td>前回処理結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyorikekkaKbn C_SyorikekkaKbn}</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IW_KhJyudKigmaebriTkykHnkWk
 * @see     GenIW_KhJyudKigmaebriTkykHnkWk
 * @see     QIW_KhJyudKigmaebriTkykHnkWk
 * @see     GenQIW_KhJyudKigmaebriTkykHnkWk
 */
public class PKIW_KhJyudKigmaebriTkykHnkWk extends AbstractExDBPrimaryKey<IW_KhJyudKigmaebriTkykHnkWk, PKIW_KhJyudKigmaebriTkykHnkWk> {

    private static final long serialVersionUID = 1L;

    public PKIW_KhJyudKigmaebriTkykHnkWk() {
    }

    public PKIW_KhJyudKigmaebriTkykHnkWk(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

    @Transient
    @Override
    public Class<IW_KhJyudKigmaebriTkykHnkWk> getEntityClass() {
        return IW_KhJyudKigmaebriTkykHnkWk.class;
    }

    private String kouteikanriid;

    public String getKouteikanriid() {
        return kouteikanriid;
    }

    public void setKouteikanriid(String pKouteikanriid) {
        kouteikanriid = pKouteikanriid;
    }

}