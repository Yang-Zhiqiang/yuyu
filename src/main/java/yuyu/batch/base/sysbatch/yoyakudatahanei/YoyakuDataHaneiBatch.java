package yuyu.batch.base.sysbatch.yoyakudatahanei;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import jp.co.slcs.swak.batch.annotation.Execute;
import jp.co.slcs.swak.date.BizDateFormat;
import jp.co.slcs.swak.util.message.MessageUtil;
import yuyu.def.MessageId;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_HolidayPtn;
import yuyu.def.classification.C_LegalHolidayKbn;
import yuyu.def.classification.C_YoyakuKbn;
import yuyu.def.db.entity.AT_Holiday;
import yuyu.def.db.entity.AT_HolidayGroup;
import yuyu.def.db.entity.AT_HolidayYoyaku;
import yuyu.infr.batch.Batch;
import yuyu.infr.batch.BatchParam;
import yuyu.infr.batch.logger.BatchLogger;

/**
 * 予約データ反映のバッチクラスです。
 */
public class YoyakuDataHaneiBatch implements Batch {

    @Inject
    private BatchLogger batchLogger;

    @Inject
    private BaseDomManager manager;

    @Inject
    private BatchParam batchParam;

    @Override
    public BatchParam getParam() {
        return batchParam;
    }

    @Execute
    @Transactional
    public void execute() {

        int kensuu = 0;

        List<AT_HolidayGroup> holidayGroupList = manager.getAllHolidayGroups();
        List<AT_HolidayYoyaku> yoyakuList = null;
        List<AT_HolidayYoyaku> taisyouYoyakuList = new ArrayList<AT_HolidayYoyaku>();
        AT_Holiday holiday = null;

        for (AT_HolidayGroup taisyouGroup : holidayGroupList) {
            yoyakuList = taisyouGroup.getHolidayYoyakus();

            for (AT_HolidayYoyaku taisyouYoyaku : yoyakuList) {

                String taisyouYoyakuHolidayGroupCd = taisyouYoyaku.getHolidayGroupCd();

                if (C_HolidayPtn.OTHER_HOLIDAYGROUP.eq(taisyouYoyaku.getHolidayPattern())) {

                    if (!isExistHolidayGroupInfo(taisyouYoyaku.getHolidayPatternParam())) {

                        BizDateFormat format = new BizDateFormat("Gyy/MM/dd");
                        String tekiyouYmdFrom = format.format(taisyouYoyaku.getTekiyouYmdFrom());
                        String tekiyouYmdTo = format.format(taisyouYoyaku.getTekiyouYmdTo());

                        batchLogger.error(MessageUtil.getMessage(MessageId.EAF0065,  MessageUtil.getMessage(MessageId.IAW0048),
                            MessageUtil.getMessage(MessageId.IAW0049), MessageUtil.getMessage(MessageId.IAW0050),
                            MessageUtil.getMessage(MessageId.IAW0051), MessageUtil.getMessage(MessageId.IAW0052),
                            MessageUtil.getMessage(MessageId.IAW0053), taisyouYoyakuHolidayGroupCd, taisyouYoyaku.getHolidayPatternNm(),
                            C_HolidayPtn.getContentByValue(taisyouYoyaku.getHolidayPattern().getValue()), tekiyouYmdFrom, tekiyouYmdTo,
                            C_LegalHolidayKbn.getContentByValue(taisyouYoyaku.getLegalHolidayKbn().getValue())));
                        continue;
                    }

                }

                if (C_YoyakuKbn.TOUROKU_YOYAKU.eq(taisyouYoyaku.getYoyakuKbn())) {
                    AT_Holiday addEntity = taisyouGroup.createHoliday();
                    addEntity.setHolidayCd(taisyouYoyaku.getHolidayCd());
                    addEntity.setLegalHolidayKbn(taisyouYoyaku.getLegalHolidayKbn());
                    addEntity.setTekiyouYmdFrom(taisyouYoyaku.getTekiyouYmdFrom());
                    addEntity.setTekiyouYmdTo(taisyouYoyaku.getTekiyouYmdTo());
                    addEntity.setHolidayPattern(taisyouYoyaku.getHolidayPattern());
                    addEntity.setHolidayPatternParam(taisyouYoyaku.getHolidayPatternParam());
                    addEntity.setHolidayPatternNm(taisyouYoyaku.getHolidayPatternNm());
                    addEntity.setHolidayPatternDescription(taisyouYoyaku.getHolidayPatternDescription());
                }
                else if (C_YoyakuKbn.HENKOU_YOYAKU.eq(taisyouYoyaku.getYoyakuKbn())) {
                    AT_Holiday upDateEntity = taisyouGroup.getHoliday(taisyouYoyaku.getHolidayCd());
                    upDateEntity.setLegalHolidayKbn(taisyouYoyaku.getLegalHolidayKbn());
                    upDateEntity.setTekiyouYmdFrom(taisyouYoyaku.getTekiyouYmdFrom());
                    upDateEntity.setTekiyouYmdTo(taisyouYoyaku.getTekiyouYmdTo());
                    upDateEntity.setHolidayPattern(taisyouYoyaku.getHolidayPattern());
                    upDateEntity.setHolidayPatternParam(taisyouYoyaku.getHolidayPatternParam());
                    upDateEntity.setHolidayPatternNm(taisyouYoyaku.getHolidayPatternNm());
                    upDateEntity.setHolidayPatternDescription(taisyouYoyaku.getHolidayPatternDescription());
                }
                else if (C_YoyakuKbn.SAKUJYO_YOYAKU.eq(taisyouYoyaku.getYoyakuKbn())) {
                    holiday = taisyouGroup.getHoliday(taisyouYoyaku.getHolidayCd());
                    taisyouGroup.getHolidays().remove(holiday);
                }
                else {
                    continue;
                }

                kensuu++;

                taisyouYoyakuList.add(taisyouYoyaku);

            }

            yoyakuList.removeAll(taisyouYoyakuList);
            taisyouYoyakuList.clear();
        }

        manager.update(holidayGroupList);

        batchLogger.info(MessageUtil.getMessage(MessageId.IAC0020, String.valueOf(kensuu)));
    }

    private boolean isExistHolidayGroupInfo(String taisyouYoyakuHolidayGroupCd) {
        AT_HolidayGroup holidayGroup = manager.getHolidayGroup(taisyouYoyakuHolidayGroupCd);

        if (holidayGroup == null) {
            return false;
        }
        return true;
    }

}
