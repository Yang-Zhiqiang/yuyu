package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_BAK_AeoiInfo;
import yuyu.def.db.mapping.GenIT_BAK_AeoiInfo;
import yuyu.def.db.meta.GenQIT_BAK_AeoiInfo;
import yuyu.def.db.meta.QIT_BAK_AeoiInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＡＥＯＩ情報バックアップテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_BAK_AeoiInfo}</td><td colspan="3">ＡＥＯＩ情報バックアップテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getTrkssikibetukey trkssikibetukey}</td><td>取消識別キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getRenno renno}</td><td>連番</td><td align="center">○</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>aeoisyoriymd</td><td>ＡＥＯＩ処理年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>aeoisyorikbn</td><td>ＡＥＯＩ処理区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AeoiSyoriKbn C_AeoiSyoriKbn}</td></tr>
 *  <tr><td>aeoikouryokusttymd</td><td>ＡＥＯＩ効力開始年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>aeoisyorisosikicd</td><td>ＡＥＯＩ処理組織コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>aeoitaisyousyakbn</td><td>ＡＥＯＩ対象者区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AeoiTaisyousyaKbn C_AeoiTaisyousyaKbn}</td></tr>
 *  <tr><td>aeoikekkakbn</td><td>ＡＥＯＩ結果区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AeoiKekkaKbn C_AeoiKekkaKbn}</td></tr>
 *  <tr><td>aeoihoujinsyuruikbn</td><td>ＡＥＯＩ法人種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_AeoiHoujinSyuruiKbn C_AeoiHoujinSyuruiKbn}</td></tr>
 *  <tr><td>aeoikouryokuendymd</td><td>ＡＥＯＩ効力終了年月日</td><td>&nbsp;</td><td align="center">V</td><td>BizDate</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_BAK_AeoiInfo
 * @see     GenIT_BAK_AeoiInfo
 * @see     QIT_BAK_AeoiInfo
 * @see     GenQIT_BAK_AeoiInfo
 */
public class PKIT_BAK_AeoiInfo extends AbstractExDBPrimaryKey<IT_BAK_AeoiInfo, PKIT_BAK_AeoiInfo> {

    private static final long serialVersionUID = 1L;

    public PKIT_BAK_AeoiInfo() {
    }

    public PKIT_BAK_AeoiInfo(
        String pKbnkey,
        String pSyono,
        String pTrkssikibetukey,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        trkssikibetukey = pTrkssikibetukey;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_BAK_AeoiInfo> getEntityClass() {
        return IT_BAK_AeoiInfo.class;
    }

    private String kbnkey;

    public String getKbnkey() {
        return kbnkey;
    }

    public void setKbnkey(String pKbnkey) {
        kbnkey = pKbnkey;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String trkssikibetukey;

    public String getTrkssikibetukey() {
        return trkssikibetukey;
    }

    public void setTrkssikibetukey(String pTrkssikibetukey) {
        trkssikibetukey = pTrkssikibetukey;
    }
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}