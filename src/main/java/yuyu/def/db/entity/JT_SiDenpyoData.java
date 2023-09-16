package yuyu.def.db.entity;

import javax.persistence.Entity;

import yuyu.common.biz.bzcommon.DenpyouDataParam;
import yuyu.def.db.mapping.GenJT_SiDenpyoData;


/**
 * 支払伝票データテーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenJT_SiDenpyoData} の JavaDoc を参照してください。<br />
 * @see     GenJT_SiDenpyoData<br />
 * @see     PKJT_SiDenpyoData<br />
 * @see     QJT_SiDenpyoData<br />
 * @see     GenQJT_SiDenpyoData<br />
 */
@Entity
public class JT_SiDenpyoData extends GenJT_SiDenpyoData implements DenpyouDataParam{

    private static final long serialVersionUID = 1L;

    public JT_SiDenpyoData() {
    }

    public JT_SiDenpyoData(String pDenrenno,Integer pEdano) {
        super(pDenrenno,pEdano);
    }



}

