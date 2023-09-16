package yuyu.def.db.id;

import javax.persistence.Transient;
import jp.co.slcs.swak.db.typesafe.AbstractExDBPrimaryKey;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import yuyu.def.classification.C_FileSyuruiCdKbn;
import yuyu.def.db.entity.AS_FileSyurui;
import yuyu.def.db.mapping.GenAS_FileSyurui;
import yuyu.def.db.meta.GenQAS_FileSyurui;
import yuyu.def.db.meta.QAS_FileSyurui;

/**
 * ファイル種類基幹テーブル のプライマリキークラスです。<br />
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">テーブルID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">{@link AS_FileSyurui}</td><td colspan="3">ファイル種類基幹テーブル</td></tr>
 *  <tr bgcolor="whitesmoke"><th>フィールドID</th><th>フィールド名</th><th>PKey</th><th>DB型</th><th>Java型</th></tr>
 *  <tr bgcolor="pink"><td>{@link #getFileSyuruiCd fileSyuruiCd}</td><td>ファイル種類コード</td><td align="center">○</td><td align="center">V</td><td>{@link C_FileSyuruiCdKbn}</td></tr>
 *  <tr><td>fileSyuruiNm</td><td>ファイル種類名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fileSyuruiKbn</td><td>ファイル種類区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_FileSyuruiKbn C_FileSyuruiKbn}</td></tr>
 *  <tr><td>fileNmPattern</td><td>ファイル名パターン</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>downloadFileNm</td><td>ダウンロードファイル名</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>fileType</td><td>ファイルタイプ</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>dataLayoutBeanClass</td><td>データレイアウトビーンクラス</td><td>&nbsp;</td><td align="center">V</td><td>String</td></tr>
 *  <tr><td>createEmptyFileUmuKbn</td><td>空ファイル出力有無区分</td><td>&nbsp;</td><td align="center">V</td><td>{@link yuyu.def.classification.C_UmuKbn C_UmuKbn}</td></tr>
 * </table>
 * @see     AS_FileSyurui
 * @see     GenAS_FileSyurui
 * @see     QAS_FileSyurui
 * @see     GenQAS_FileSyurui
 */
public class PKAS_FileSyurui extends AbstractExDBPrimaryKey<AS_FileSyurui, PKAS_FileSyurui> {

    private static final long serialVersionUID = 1L;

    public PKAS_FileSyurui() {
    }

    public PKAS_FileSyurui(C_FileSyuruiCdKbn pFileSyuruiCd) {
        fileSyuruiCd = pFileSyuruiCd;
    }

    @Transient
    @Override
    public Class<AS_FileSyurui> getEntityClass() {
        return AS_FileSyurui.class;
    }

    private C_FileSyuruiCdKbn fileSyuruiCd;

    @org.hibernate.annotations.Type(type="UserType_C_FileSyuruiCdKbn")
    public C_FileSyuruiCdKbn getFileSyuruiCd() {
        return fileSyuruiCd;
    }

    public void setFileSyuruiCd(C_FileSyuruiCdKbn pFileSyuruiCd) {
        fileSyuruiCd = pFileSyuruiCd;
    }

}