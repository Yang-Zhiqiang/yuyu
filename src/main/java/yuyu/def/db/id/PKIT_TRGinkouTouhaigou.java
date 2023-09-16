package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.conversion.annotations.DataConvert;
import jp.co.slcs.swak.conversion.annotations.Trim;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import jp.co.slcs.swak.validation.constraints.Digit;
import jp.co.slcs.swak.validation.constraints.Length;
import yuyu.def.db.entity.IT_TRGinkouTouhaigou;
import yuyu.def.db.mapping.GenIT_TRGinkouTouhaigou;
import yuyu.def.db.meta.GenQIT_TRGinkouTouhaigou;
import yuyu.def.db.meta.QIT_TRGinkouTouhaigou;

/**
 * 銀行統廃合ＴＲテーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link IT_TRGinkouTouhaigou}</td><td colspan="3">銀行統廃合ＴＲテーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getBfrikkatuseibibankcd bfrikkatuseibibankcd}</td><td>（変更前）一括整備用銀行コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr bgcolor="pink"><td>{@link #getBfrikkatuseibisitencd bfrikkatuseibisitencd}</td><td>（変更前）一括整備用支店コード</td><td align="center">○</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newikkatuseibibankcd</td><td>（変更後）一括整備用銀行コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>newikkatuseibisitencd</td><td>（変更後）一括整備用支店コード</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 * </table>
 * @see     IT_TRGinkouTouhaigou
 * @see     GenIT_TRGinkouTouhaigou
 * @see     QIT_TRGinkouTouhaigou
 * @see     GenQIT_TRGinkouTouhaigou
 */
public class PKIT_TRGinkouTouhaigou extends AbstractExDBPrimaryKey<IT_TRGinkouTouhaigou, PKIT_TRGinkouTouhaigou> {

    private static final long serialVersionUID = 1L;

    public PKIT_TRGinkouTouhaigou() {
    }

    public PKIT_TRGinkouTouhaigou(String pBfrikkatuseibibankcd, String pBfrikkatuseibisitencd) {
        bfrikkatuseibibankcd = pBfrikkatuseibibankcd;
        bfrikkatuseibisitencd = pBfrikkatuseibisitencd;
    }

    @Transient
    @Override
    public Class<IT_TRGinkouTouhaigou> getEntityClass() {
        return IT_TRGinkouTouhaigou.class;
    }

    private String bfrikkatuseibibankcd;

    public String getBfrikkatuseibibankcd() {
        return bfrikkatuseibibankcd;
    }

    public void setBfrikkatuseibibankcd(String pBfrikkatuseibibankcd) {
        bfrikkatuseibibankcd = pBfrikkatuseibibankcd;
    }
    private String bfrikkatuseibisitencd;

    public String getBfrikkatuseibisitencd() {
        return bfrikkatuseibisitencd;
    }

    public void setBfrikkatuseibisitencd(String pBfrikkatuseibisitencd) {
        bfrikkatuseibisitencd = pBfrikkatuseibisitencd;
    }

}