package yuyu.def.db.dao;

import static jp.co.slcs.swak.db.typesafe.ExDBJPQLUtil.*;

import java.util.List;

import javax.persistence.OrderBy;

import jp.co.slcs.swak.bizinfr.dao.AbstractDao;

import org.apache.commons.lang.StringUtils;

import yuyu.def.db.entity.WT_Page;
import yuyu.def.db.id.PKWT_Page;
import yuyu.def.db.meta.QWT_Page;

/**
 * ページテーブル(WT_Page) テーブルアクセス用の DAO クラスです。<br />
 *
 */
public class WT_PageDao extends AbstractDao<WT_Page> {

    public WT_PageDao() {

        super(WT_Page.class);
    }

    public WT_Page getPage(String pImageId, String pSyoruiToutyakuTime, Integer pPageNo) {
        return selectPk(new PKWT_Page(pImageId, pSyoruiToutyakuTime, pPageNo));
    }

    public List<WT_Page> getAllPage() {

        return selectAll();
    }

    @OrderBy(WT_Page.PAGENO + $ASC)
    public List<WT_Page> getPages(String pImageId) {

        WT_Page condition = new WT_Page();

        condition.setIwfImageId(pImageId);

        return getPages(condition);
    }

    public List<WT_Page> getPages(String pImageId, String pSyoruiToutyakuTimeFrom, String pSyoruiToutyakuTimeTo) {

        QWT_Page page = new QWT_Page("page");

        StringBuilder mainQuery = new StringBuilder();
        boolean firstFlg = true;
        mainQuery.append($SELECT + page);
        mainQuery.append($FROM + page.WT_Page());


        if (!StringUtils.isEmpty(pImageId)) {
            mainQuery.append($WHERE + page.iwfImageId.eq(pImageId));
            firstFlg = false;
        }

        if (!StringUtils.isEmpty(pSyoruiToutyakuTimeFrom)) {
            if(firstFlg){
                mainQuery.append($WHERE);
                firstFlg = false;
            } else {
                mainQuery.append($AND);
            }
            mainQuery.append(page.syoruittykymdtime.ge(pSyoruiToutyakuTimeFrom));
        }

        if (!StringUtils.isEmpty(pSyoruiToutyakuTimeTo)) {
            if(firstFlg){
                mainQuery.append($WHERE);
                firstFlg = false;
            } else {
                mainQuery.append($AND);
            }
            mainQuery.append(page.syoruittykymdtime.le(pSyoruiToutyakuTimeTo));
        }
        mainQuery.append($ORDER_BY(page.pageno + $ASC));

        return em.createJPQL(mainQuery.toString()).bind(page).getResultList();
    }

    private List<WT_Page> getPages(WT_Page pWT_Page) {

        return select(pWT_Page);
    }
}