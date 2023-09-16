package yuyu.def.db.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import jp.co.slcs.swak.core.inject.SWAKInjector;
import yuyu.common.biz.bzcommon.KbnKeyGenerator;
import yuyu.def.db.mapping.GenIT_SyuunouHenknRireki;


/**
 * 収納返金履歴テーブル エンティティです。<br />
 * テーブル定義の詳細はスーパークラス {@link GenIT_SyuunouHenknRireki} の JavaDoc を参照してください。<br />
 * @see     GenIT_SyuunouHenknRireki<br />
 * @see     PKIT_SyuunouHenknRireki<br />
 * @see     QIT_SyuunouHenknRireki<br />
 * @see     GenQIT_SyuunouHenknRireki<br />
 */
@Entity
public class IT_SyuunouHenknRireki extends GenIT_SyuunouHenknRireki {

    private static final long serialVersionUID = 1L;

    public IT_SyuunouHenknRireki() {
    }

    public IT_SyuunouHenknRireki(String pKbnkey,String pSyono,String pDenrenno,Integer pEdano) {
        super(pKbnkey,pSyono,pDenrenno,pEdano);
    }

    public IT_SyuunouHenknRireki(String pSyono,String pDenrenno,Integer pEdano) {
        super(SWAKInjector.getInstance(KbnKeyGenerator.class).generate(pSyono),pSyono,pDenrenno,pEdano);
    }


    private IT_AnsyuKihon iT_AnsyuKihon ;

    @ManyToOne(cascade = { CascadeType.REFRESH, CascadeType.DETACH })
    @JoinColumns({
        @JoinColumn(name=IT_SyuunouHenknRireki.KBNKEY  , referencedColumnName=IT_AnsyuKihon.KBNKEY, insertable=false, updatable=false),
        @JoinColumn(name=IT_SyuunouHenknRireki.SYONO  , referencedColumnName=IT_AnsyuKihon.SYONO, insertable=false, updatable=false)
    })
    public IT_AnsyuKihon getAnsyuKihon() {
        return iT_AnsyuKihon;
    }

    public void setAnsyuKihon(IT_AnsyuKihon pIT_AnsyuKihon) {
        this.iT_AnsyuKihon = pIT_AnsyuKihon;
    }

}

