package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.db.entity.DM_JimutetuzukiRireki;
import yuyu.def.db.mapping.GenDM_JimutetuzukiRireki;
import yuyu.def.db.meta.GenQDM_JimutetuzukiRireki;
import yuyu.def.db.meta.QDM_JimutetuzukiRireki;

/**
 * 事務手続マスタ履歴保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link DM_JimutetuzukiRireki}</td><td colspan="3">事務手続マスタ履歴保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKensuuHokanYmd kensuuHokanYmd}</td><td>件数保管日</td><td align="center">○</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getJimutetuzukicd jimutetuzukicd}</td><td>事務手続コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSubSystemId subSystemId}</td><td>サブシステムＩＤ</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>jimutetuzukinm</td><td>事務手続名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>imagerenkeikbn</td><td>イメージ連携区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_ImagerenkeiKbn C_ImagerenkeiKbn}</td></tr>
 *  <tr><td>hyoujijyun</td><td>表示順</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syukouteijimutetuzukicd</td><td>主工程事務手続コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     DM_JimutetuzukiRireki
 * @see     GenDM_JimutetuzukiRireki
 * @see     QDM_JimutetuzukiRireki
 * @see     GenQDM_JimutetuzukiRireki
 */
public class PKDM_JimutetuzukiRireki extends AbstractExDBPrimaryKey<DM_JimutetuzukiRireki, PKDM_JimutetuzukiRireki> {

    private static final long serialVersionUID = 1L;

    public PKDM_JimutetuzukiRireki() {
    }

    public PKDM_JimutetuzukiRireki(
        BizDate pKensuuHokanYmd,
        String pJimutetuzukicd,
        String pSubSystemId
    ) {
        kensuuHokanYmd = pKensuuHokanYmd;
        jimutetuzukicd = pJimutetuzukicd;
        subSystemId = pSubSystemId;
    }

    @Transient
    @Override
    public Class<DM_JimutetuzukiRireki> getEntityClass() {
        return DM_JimutetuzukiRireki.class;
    }

    private BizDate kensuuHokanYmd;

    @org.hibernate.annotations.Type(type="BizDateType")
    public BizDate getKensuuHokanYmd() {
        return kensuuHokanYmd;
    }

    public void setKensuuHokanYmd(BizDate pKensuuHokanYmd) {
        kensuuHokanYmd = pKensuuHokanYmd;
    }
    private String jimutetuzukicd;

    public String getJimutetuzukicd() {
        return jimutetuzukicd;
    }

    public void setJimutetuzukicd(String pJimutetuzukicd) {
        jimutetuzukicd = pJimutetuzukicd;
    }
    private String subSystemId;

    public String getSubSystemId() {
        return subSystemId;
    }

    public void setSubSystemId(String pSubSystemId) {
        subSystemId = pSubSystemId;
    }

}