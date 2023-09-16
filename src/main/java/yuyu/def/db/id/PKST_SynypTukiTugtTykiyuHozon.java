package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.Padding;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.mapping.GenST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.meta.GenQST_SynypTukiTugtTykiyuHozon;
import yuyu.def.db.meta.QST_SynypTukiTugtTykiyuHozon;

/**
 * 収入Ｐ統計当月処理中継用保存テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ST_SynypTukiTugtTykiyuHozon}</td><td colspan="3">収入Ｐ統計当月処理中継用保存テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysrkijyunym ztysrkijyunym}</td><td>（中継用）数理用基準年月</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysrkakutyoujobcd ztysrkakutyoujobcd}</td><td>（中継用）数理用拡張ジョブコード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtysequenceno ztysequenceno}</td><td>（中継用）シーケンス番号</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>ztydatakanrino</td><td>（中継用）データ管理番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyuutouym</td><td>（中継用）充当年月</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjyuutoukaisuu</td><td>（中継用）充当回数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyrecordkbn</td><td>（中継用）レコード区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztydenymd</td><td>（中継用）伝票日付</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyoricd</td><td>（中継用）処理コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhenkousyoriymd</td><td>（中継用）変更処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykbnkeiriyousegmentcd</td><td>（中継用）区分経理用セグメントコード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyzennoujiikkatubaraijytgk</td><td>（中継用）前納時一括払充当額</td><td>&nbsp;</td><td align="center">N</td><td>Long</td></tr>
 *  <tr><td>ztysrdenrenno</td><td>（中継用）数理用伝票データ連番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ST_SynypTukiTugtTykiyuHozon
 * @see     GenST_SynypTukiTugtTykiyuHozon
 * @see     QST_SynypTukiTugtTykiyuHozon
 * @see     GenQST_SynypTukiTugtTykiyuHozon
 */
public class PKST_SynypTukiTugtTykiyuHozon extends AbstractExDBPrimaryKey<ST_SynypTukiTugtTykiyuHozon, PKST_SynypTukiTugtTykiyuHozon> {

    private static final long serialVersionUID = 1L;

    public PKST_SynypTukiTugtTykiyuHozon() {
    }

    public PKST_SynypTukiTugtTykiyuHozon(
        String pZtysrkijyunym,
        String pZtysrkakutyoujobcd,
        Integer pZtysequenceno
    ) {
        ztysrkijyunym = pZtysrkijyunym;
        ztysrkakutyoujobcd = pZtysrkakutyoujobcd;
        ztysequenceno = pZtysequenceno;
    }

    @Transient
    @Override
    public Class<ST_SynypTukiTugtTykiyuHozon> getEntityClass() {
        return ST_SynypTukiTugtTykiyuHozon.class;
    }

    private String ztysrkijyunym;

    public String getZtysrkijyunym() {
        return ztysrkijyunym;
    }

    public void setZtysrkijyunym(String pZtysrkijyunym) {
        ztysrkijyunym = pZtysrkijyunym;
    }
    private String ztysrkakutyoujobcd;

    public String getZtysrkakutyoujobcd() {
        return ztysrkakutyoujobcd;
    }

    public void setZtysrkakutyoujobcd(String pZtysrkakutyoujobcd) {
        ztysrkakutyoujobcd = pZtysrkakutyoujobcd;
    }
    private Integer ztysequenceno;

    public Integer getZtysequenceno() {
        return ztysequenceno;
    }

    public void setZtysequenceno(Integer pZtysequenceno) {
        ztysequenceno = pZtysequenceno;
    }

}