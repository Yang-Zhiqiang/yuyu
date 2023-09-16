package yuyu.def.db.entity;

import javax.persistence.Entity;

import jp.co.slcs.swak.date.BizDate;
import yuyu.def.db.id.PKAS_FileServerInfo;
import yuyu.def.db.mapping.GenAS_FileServerInfo;
import yuyu.def.db.meta.GenQAS_FileServerInfo;
import yuyu.def.db.meta.QAS_FileServerInfo;

/**
 * ファイルサーバー情報基幹テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenAS_FileServerInfo} の JavaDoc を参照してください。
 * @see     GenAS_FileServerInfo
 * @see     PKAS_FileServerInfo
 * @see     QAS_FileServerInfo
 * @see     GenQAS_FileServerInfo
 */
@Entity
public class AS_FileServerInfo extends GenAS_FileServerInfo {

    private static final long serialVersionUID = 1L;

    public AS_FileServerInfo() {
    }

    public AS_FileServerInfo(Integer pSetteiNo, BizDate pTekiyouYmdFrom) {
        super(pSetteiNo, pTekiyouYmdFrom);
    }

}
