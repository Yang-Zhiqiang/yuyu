package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.ZT_OnlineLincSousinTy;
import yuyu.def.db.mapping.GenZT_OnlineLincSousinTy;
import yuyu.def.db.meta.GenQZT_OnlineLincSousinTy;
import yuyu.def.db.meta.QZT_OnlineLincSousinTy;

/**
 * オンラインＬＩＮＣ送信ファイルテーブル（中） のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link ZT_OnlineLincSousinTy}</td><td colspan="3">オンラインＬＩＮＣ送信ファイルテーブル（中）</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr><td>ztydatakbn</td><td>（中継用）データ区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtyrecordsyubetukbn ztyrecordsyubetukbn}</td><td>（中継用）レコード種別区分</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhenkoutype</td><td>（中継用）変更タイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorikekkacd</td><td>（中継用）処理結果コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorikekkaerrjiyuu</td><td>（中継用）処理結果エラー事由</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysyorikekkaerrno</td><td>（中継用）処理結果エラー項番</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztynayoserecordsuu</td><td>（中継用）名寄せレコード数</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykanyuusyano</td><td>（中継用）加入者番号</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyoukaisiyouknnm</td><td>（中継用）協会使用カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseikbn</td><td>（中継用）被保険者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknseiymd</td><td>（中継用）被保険者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykymd</td><td>（中継用）契約年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyhhknsydouituhyouji</td><td>（中継用）契約者被保険者同一表示</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysousinmotokaisyacd</td><td>（中継用）送信元会社コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhhknadrkn</td><td>（中継用）被保険者住所（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysiginyuintkykntgkstr</td><td>（中継用）災害入院特約日額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysppinyuintkykntgkstr</td><td>（中継用）疾病入院特約日額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysijnbyutkykntgkstr</td><td>（中継用）成人病特約日額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysonotatokuyakuntgkstr</td><td>（中継用）その他特約日額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytrkmousideymd</td><td>（中継用）登録申出年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztylincsyoriymd</td><td>（中継用）ＬＩＮＣ処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyuyusiyouknnm</td><td>（中継用）住友使用カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getZtykykkanrino ztykykkanrino}</td><td>（中継用）契約管理番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhozenymd</td><td>（中継用）保全年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykknnm</td><td>（中継用）契約者カナ氏名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhutuusbsstr</td><td>（中継用）普通死亡保険金額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztysgsbstr</td><td>（中継用）災害死亡保険金額（文字列）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykakusyasiyouran</td><td>（中継用）各社使用欄</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymousideflg</td><td>（中継用）申出フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymousideflgsetymd</td><td>（中継用）申出フラグ設定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztymousideflgkaijyoymd</td><td>（中継用）申出フラグ解除年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyjgyhknflg</td><td>（中継用）事業保険フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztytnknflg</td><td>（中継用）転換フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseikbn</td><td>（中継用）契約者性別区分</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykyksyaseiymd</td><td>（中継用）契約者生年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykadrkn</td><td>（中継用）契約者住所（カナ）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv17</td><td>（中継用）予備項目Ｖ１７</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyknjhhknmei30</td><td>（中継用）漢字被保険者名（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjkyknm30</td><td>（中継用）漢字契約者名（３０桁）</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zty15sai1000manflg</td><td>（中継用）１５歳未満１０００万超フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykjhngflg</td><td>（中継用）漢字範囲外フラグ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztykykytymd</td><td>（中継用）契約予定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyhozenytymd</td><td>（中継用）保全予定年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zty15mimantkhukaymd</td><td>（中継用）１５歳未満特約中途付加年月日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>zty15mimantkhukayoteiymd</td><td>（中継用）１５歳未満特約中途付加予定日</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>ztyyobiv46</td><td>（中継用）予備項目Ｖ４６</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     ZT_OnlineLincSousinTy
 * @see     GenZT_OnlineLincSousinTy
 * @see     QZT_OnlineLincSousinTy
 * @see     GenQZT_OnlineLincSousinTy
 */
public class PKZT_OnlineLincSousinTy extends AbstractExDBPrimaryKey<ZT_OnlineLincSousinTy, PKZT_OnlineLincSousinTy> {

    private static final long serialVersionUID = 1L;

    public PKZT_OnlineLincSousinTy() {
    }

    public PKZT_OnlineLincSousinTy(String pZtyrecordsyubetukbn, String pZtykykkanrino) {
        ztyrecordsyubetukbn = pZtyrecordsyubetukbn;
        ztykykkanrino = pZtykykkanrino;
    }

    @Transient
    @Override
    public Class<ZT_OnlineLincSousinTy> getEntityClass() {
        return ZT_OnlineLincSousinTy.class;
    }

    private String ztyrecordsyubetukbn;

    public String getZtyrecordsyubetukbn() {
        return ztyrecordsyubetukbn;
    }

    public void setZtyrecordsyubetukbn(String pZtyrecordsyubetukbn) {
        ztyrecordsyubetukbn = pZtyrecordsyubetukbn;
    }
    private String ztykykkanrino;

    public String getZtykykkanrino() {
        return ztykykkanrino;
    }

    public void setZtykykkanrino(String pZtykykkanrino) {
        ztykykkanrino = pZtykykkanrino;
    }

}