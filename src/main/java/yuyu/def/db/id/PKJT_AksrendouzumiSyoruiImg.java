package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import yuyu.def.db.entity.JT_AksrendouzumiSyoruiImg;
import yuyu.def.db.mapping.GenJT_AksrendouzumiSyoruiImg;
import yuyu.def.db.meta.GenQJT_AksrendouzumiSyoruiImg;
import yuyu.def.db.meta.QJT_AksrendouzumiSyoruiImg;
import yuyu.infr.validation.constraints.SyoukenNo;

/**
 * ＡＫＳ連動済書類情報テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link JT_AksrendouzumiSyoruiImg}</td><td colspan="3">ＡＫＳ連動済書類情報テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getSkno skno}</td><td>請求番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getSyono syono}</td><td>証券番号</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getImageid imageid}</td><td>イメージID</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>syoruiimagepagecnt</td><td>書類イメージページ数</td><td>&nbsp;</td><td align="center">N</td><td>Integer</td></tr>
 *  <tr><td>syoruiCd</td><td>書類コード</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_SyoruiCdKbn C_SyoruiCdKbn}</td></tr>
 *  <tr><td>aksrendoupdffilenm</td><td>ＡＫＳ連動用ＰＤＦファイル名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinKinou</td><td>業務用更新機能ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinsyaId</td><td>業務用更新者ＩＤ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>gyoumuKousinTime</td><td>業務用更新時間</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     JT_AksrendouzumiSyoruiImg
 * @see     GenJT_AksrendouzumiSyoruiImg
 * @see     QJT_AksrendouzumiSyoruiImg
 * @see     GenQJT_AksrendouzumiSyoruiImg
 */
public class PKJT_AksrendouzumiSyoruiImg extends AbstractExDBPrimaryKey<JT_AksrendouzumiSyoruiImg, PKJT_AksrendouzumiSyoruiImg> {

    private static final long serialVersionUID = 1L;

    public PKJT_AksrendouzumiSyoruiImg() {
    }

    public PKJT_AksrendouzumiSyoruiImg(
        String pSkno,
        String pSyono,
        String pImageid
    ) {
        skno = pSkno;
        syono = pSyono;
        imageid = pImageid;
    }

    @Transient
    @Override
    public Class<JT_AksrendouzumiSyoruiImg> getEntityClass() {
        return JT_AksrendouzumiSyoruiImg.class;
    }

    private String skno;

    public String getSkno() {
        return skno;
    }

    public void setSkno(String pSkno) {
        skno = pSkno;
    }
    private String syono;

    public String getSyono() {
        return syono;
    }

    public void setSyono(String pSyono) {
        syono = pSyono;
    }
    private String imageid;

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String pImageid) {
        imageid = pImageid;
    }

}