package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.IT_AeoiInfo;
import yuyu.def.db.mapping.GenIT_AeoiInfo;
import yuyu.def.db.meta.GenQIT_AeoiInfo;
import yuyu.def.db.meta.QIT_AeoiInfo;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＡＥＯＩ情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_AeoiInfo}</td><td colspan="3">ＡＥＯＩ情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getKbnkey kbnkey}</td><td>区分キー</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
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
 * @see     IT_AeoiInfo
 * @see     GenIT_AeoiInfo
 * @see     QIT_AeoiInfo
 * @see     GenQIT_AeoiInfo
 */
public class PKIT_AeoiInfo extends AbstractExDBPrimaryKey<IT_AeoiInfo, PKIT_AeoiInfo> {

    private static final long serialVersionUID = 1L;

    public PKIT_AeoiInfo() {
    }

    public PKIT_AeoiInfo(
        String pKbnkey,
        String pSyono,
        Integer pRenno
    ) {
        kbnkey = pKbnkey;
        syono = pSyono;
        renno = pRenno;
    }

    @Transient
    @Override
    public Class<IT_AeoiInfo> getEntityClass() {
        return IT_AeoiInfo.class;
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
    private Integer renno;

    public Integer getRenno() {
        return renno;
    }

    public void setRenno(Integer pRenno) {
        renno = pRenno;
    }

}