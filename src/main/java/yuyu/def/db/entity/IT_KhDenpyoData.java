package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.DenpyouDataParam;
import yuyu.def.db.mapping.GenIT_KhDenpyoData;


/**
 * 契約保全伝票データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_KhDenpyoData} の JavaDoc を参照してください。<br />
 * @see     GenIT_KhDenpyoData<br />
 * @see     PKIT_KhDenpyoData<br />
 * @see     QIT_KhDenpyoData<br />
 * @see     GenQIT_KhDenpyoData<br />
 */
@Entity
public class IT_KhDenpyoData extends GenIT_KhDenpyoData implements DenpyouDataParam{

    private static final long serialVersionUID = 1L;

    public IT_KhDenpyoData() {
    }

    public IT_KhDenpyoData(String pDenrenno,Integer pEdano) {
        super(pDenrenno,pEdano);
    }



}

