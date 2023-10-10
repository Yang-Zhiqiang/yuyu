package yuyu.app.base.log.accesslogsyoukai;

import static yuyu.app.base.log.accesslogsyoukai.GenAccessLogSyoukaiConstants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import jp.co.slcs.swak.bizinfr.exception.BizAppException;
import jp.co.slcs.swak.bizinfr.exception.BizLogicException;
import jp.co.slcs.swak.core.configuration.CoreConfig;
import jp.co.slcs.swak.date.BizDate;
import jp.co.slcs.swak.util.bean.BeanUtil;
import jp.co.slcs.swak.util.message.MessageUtil;
import jp.co.slcs.swak.web.message.MessageManager;
import jp.co.slcs.swak.web.ui.LabelValuePair;
import jp.co.slcs.swak.web.ui.UserDefsList;

import org.slf4j.Logger;

import yuyu.def.MessageId;
import yuyu.def.base.configuration.YuyuBaseConfig;
import yuyu.def.base.manager.BaseDomManager;
import yuyu.def.classification.C_KinouKbn;
import yuyu.def.db.entity.AM_User;
import yuyu.def.db.entity.AS_Category;
import yuyu.def.db.entity.AS_Kinou;
import yuyu.def.db.entity.AS_SubSystem;
import yuyu.def.db.entity.AT_AccessLog;
import yuyu.def.db.entity.AT_AccessLogSyousai;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;

/**
 * アクセスログ照会 のビジネスロジックです。
 */
public class AccessLogSyoukaiBizLogic {

    @SuppressWarnings("unused")
    @Inject
    private static Logger logger;

    @Inject
    private AccessLogSyoukaiUiBean uiBean;

    @Inject
    @SuppressWarnings("unused")
    private CoreConfig swakCoreConfig;

    @Inject
    BaseDomManager baseDomManager;

    @Inject
    private MessageManager messageManager;

    void init() {
        if (baseDomManager.getAccessLogCount(null, null, null, null, null, null, null, null, null, null, null, null) == 0) {
            throw new BizAppException(MessageId.EAF0058,
                MessageUtil.getMessage(MessageId.IAW0042),
                MessageUtil.getMessage(MessageId.IAW0044));
        }

        clear();

        uiBean.setSubSystemIdOptionBeanList(
            insertBlank(
                Iterables.transform(
                    new Ordering<AS_SubSystem>() {
                        @Override
                        public int compare(AS_SubSystem subsys1, AS_SubSystem subsys2) {
                            return subsys1.getSortNo().compareTo(subsys2.getSortNo());
                        }
                    }.sortedCopy(
                        baseDomManager.getAllSubSystems()
                        ),
                        new Function<AS_SubSystem, LabelValuePair>() {
                        @Override
                        public LabelValuePair apply(AS_SubSystem subsys) {
                            return new LabelValuePair(subsys.getSubSystemNm(), subsys.getSubSystemId());
                        }
                    }
                    )
                )
            );

        uiBean.setCategoryIdOptionBeanList(
            insertBlank(
                Iterables.transform(
                    new Ordering<AS_Category>() {
                        @Override
                        public int compare(AS_Category category1, AS_Category category2) {
                            AS_SubSystem subsys1 = category1.getSubSystem();
                            AS_SubSystem subsys2 = category2.getSubSystem();
                            int result = subsys1.getSortNo().compareTo(subsys2.getSortNo());
                            if (result != 0) {
                                return result;
                            }

                            return category1.getSortNo().compareTo(category2.getSortNo());
                        }
                    }.sortedCopy(
                        baseDomManager.getAllCategories()
                        ),
                        new Function<AS_Category, LabelValuePair>() {
                        @Override
                        public LabelValuePair apply(AS_Category category) {
                            return new LabelValuePair(
                                category.getCategoryNm(),
                                category.getSubSystemId() + "." +
                                    category.getCategoryId()
                                );
                        }
                    }
                    )
                )
            );

        uiBean.setKinouIdOptionBeanList(
            insertBlank(
                Iterables.transform(
                    new Ordering<AS_Kinou>() {
                        @Override
                        public int compare(AS_Kinou kinou1, AS_Kinou kinou2) {
                            AS_SubSystem subsys1 = kinou1.getSubSystem();
                            AS_SubSystem subsys2 = kinou2.getSubSystem();
                            int result = subsys1.getSortNo().compareTo(subsys2.getSortNo());
                            if (result != 0) {
                                return result;
                            }

                            AS_Category category1 = kinou1.getCategory();
                            AS_Category category2 = kinou2.getCategory();
                            result = category1.getSortNo().compareTo(category2.getSortNo());
                            if (result != 0) {
                                return result;
                            }

                            return kinou1.getSortNo().compareTo(kinou2.getSortNo());
                        }
                    }.sortedCopy(
                        baseDomManager.getAllKinous()
                        ),
                        new Function<AS_Kinou, LabelValuePair>() {
                        @Override
                        public LabelValuePair apply(AS_Kinou kinou) {
                            return new LabelValuePair(
                                kinou.getKinouNm(),
                                kinou.getSubSystemId() + "." +
                                    kinou.getCategoryId() + "." +
                                    kinou.getKinouId() + "." +
                                    kinou.getKinouKbn()
                                );
                        }
                    }
                    )
                )
            );

        uiBean.setSyoriYmdFrom(BizDate.getSysDate());

    }

    void clear() {
    }

    void search() {

        relationChk();

        uiBean.setAccessLogInfoList(null);

        messageManager.removeConversationMessageId(MessageId.WAC0010, uiBean.getAccessLogInfoCount(),
            uiBean.getMaxShutokuKensu());

        String categoryId = uiBean.getCategoryId();
        String kinouId = uiBean.getKinouId();
        C_KinouKbn kinouKbn = uiBean.getKinouKbn();

        if (!Strings.isNullOrEmpty(categoryId)) {
            categoryId = ImmutableList.copyOf(categoryId.split("\\.")).reverse().get(0);
        }

        if (!Strings.isNullOrEmpty(kinouId)) {
            kinouId = ImmutableList.copyOf(kinouId.split("\\.")).reverse().get(1);
        }

        long count = baseDomManager.getAccessLogCount(
            uiBean.getSubSystemId(),
            categoryId,
            kinouId,
            kinouKbn,
            uiBean.getSyoriYmdFrom(),
            uiBean.getSyoriTimeFrom(),
            uiBean.getSyoriYmdTo(),
            uiBean.getSyoriTimeTo(),
            uiBean.getUserId(),
            uiBean.getIpAddress(),
            uiBean.getSessionId(),
            uiBean.getLogKindCd()
            );

        if (count == 0) {
            messageManager.addMessageId(MessageId.IAC0021, MessageUtil.getMessage(MessageId.IAW0042));
            return;
        }

        List<AccessLogInfoListDataSourceBean> list = new ArrayList<AccessLogInfoListDataSourceBean>();

        list = Lists.transform(
            baseDomManager.selAccessLogs(
                uiBean.getSubSystemId(),
                categoryId,
                kinouId,
                kinouKbn,
                uiBean.getSyoriYmdFrom(),
                uiBean.getSyoriTimeFrom(),
                uiBean.getSyoriYmdTo(),
                uiBean.getSyoriTimeTo(),
                uiBean.getUserId(),
                uiBean.getIpAddress(),
                uiBean.getSessionId(),
                uiBean.getLogKindCd()
                ),
                new Function<AT_AccessLog, AccessLogInfoListDataSourceBean>() {

                private Map<String, AS_Kinou> kinouMap = Maps.newHashMap();
                private Map<String, AM_User> userMap = Maps.newHashMap();

                @Override
                public AccessLogInfoListDataSourceBean apply(AT_AccessLog accessLog) {
                    return new AccessLogInfoListDataSourceBean(
                        accessLog,
                        getKinou(accessLog.getKinouId()),
                        getUser(accessLog.getSyoriUserId())
                        );
                }

                private AS_Kinou getKinou(String pKinouId) {
                    if (Strings.isNullOrEmpty(pKinouId)) {
                        return null;
                    }
                    if (!kinouMap.containsKey(pKinouId)) {
                        kinouMap.put(
                            pKinouId,
                            baseDomManager.getDetachedKinou(pKinouId)
                            );
                    }
                    return kinouMap.get(pKinouId);
                }

                private AM_User getUser(String pUserId) {
                    if (!userMap.containsKey(pUserId)) {
                        userMap.put(
                            pUserId,
                            baseDomManager.getDetachedUser(pUserId)
                            );
                    }
                    return userMap.get(pUserId);
                }
            }
            );

        uiBean.setAccessLogInfoCount(String.valueOf(count));

        if (count > YuyuBaseConfig.getInstance().getMaxShutokuKensu()) {

            setConversationMessage();

            for (int i = list.size() - 1; i >= YuyuBaseConfig.getInstance().getMaxShutokuKensu(); i--) {
                list.remove(i);
            }

        }

        uiBean.setAccessLogInfoList(ImmutableList.copyOf(list));

    }

    @SuppressWarnings("null")
    void showSyousai() {

        messageManager.removeConversationMessageId(MessageId.WAC0010, uiBean.getAccessLogInfoCount(),
            uiBean.getMaxShutokuKensu());

        AccessLogInfoListDataSourceBean accessLogInfoBean = uiBean.getAccessLogInfoListDataSource().getSelectedBean();

        AT_AccessLog accessLogEntity = baseDomManager.getAccessLog(accessLogInfoBean.getAccessLog().getLogId());

        List<AT_AccessLogSyousai> accessLogSyousaiList = baseDomManager.getAccessLogSyousaisByLogIdEdaNoOrder(
            accessLogInfoBean.getAccessLog().getLogId()
            );

        List<AT_AccessLogSyousai> accessLogSyousaiMargedList = Lists.newLinkedList();
        int edaNo = 0;
        AT_AccessLogSyousai detail = null;
        for (AT_AccessLogSyousai partOfDetail : accessLogSyousaiList) {
            if (!partOfDetail.getLogSyousaiData().startsWith("\t")) {
                if (detail != null) {
                    accessLogSyousaiMargedList.add(detail);
                }
                edaNo++;
                detail = partOfDetail;
                detail.setSyousaiEdaNo(Long.valueOf(edaNo));
            } else {
                detail.setLogSyousaiData(
                    detail.getLogSyousaiData() +
                    partOfDetail.getLogSyousaiData().substring(1)
                    );
            }
        }
        accessLogSyousaiMargedList.add(detail);

        uiBean.setSyoriTime(accessLogInfoBean.getSyoriTime());
        uiBean.setAccessLog(accessLogEntity);
        uiBean.setUser(accessLogInfoBean.getUser());
        uiBean.setKinou(accessLogInfoBean.getKinou());
        uiBean.setAccessDetailLogInfo(
            BeanUtil.createList(
                AccessDetailLogInfoDataSourceBean.class,
                accessLogSyousaiMargedList
                )
            );
    }

    void chkAccessLogInfoCountExceed() {

        if (!Strings.isNullOrEmpty(uiBean.getAccessLogInfoCount())) {
            long count = Long.valueOf(uiBean.getAccessLogInfoCount());

            if (count > YuyuBaseConfig.getInstance().getMaxShutokuKensu()) {

                setConversationMessage();
            }
        }
    }

    void clearEntity() {
        uiBean.setAccessLog(new AT_AccessLog());
    }


    private static UserDefsList insertBlank(Iterable<LabelValuePair> optionList) {
        UserDefsList list = new UserDefsList();
        list.addAll(
            ImmutableList.<LabelValuePair> builder()
            .add(
                new LabelValuePair(
                    AccessLogSyoukaiConstants.BLANK,
                    AccessLogSyoukaiConstants.BLANK
                    )
                )
                .addAll(optionList)
                .build()
            );
        return list;
    }

    private void relationChk() {

        chkDateTimeContext();

        chkSyoriYmdTimePartBlank();
    }

    private void chkDateTimeContext() {
        BizDate syoriYmdFrom = uiBean.getSyoriYmdFrom();
        BizDate syoriYmdTo = uiBean.getSyoriYmdTo();

        if (syoriYmdFrom != null && syoriYmdTo != null) {
            if (syoriYmdFrom.compareTo(syoriYmdTo) > 0) {
                throw new BizLogicException(MessageId.EAC0005, DDID_SEARCHCONDITIONS_SYORIYMDFROM,
                    DDID_SEARCHCONDITIONS_SYORIYMDTO);
            } else if (syoriYmdFrom.compareTo(syoriYmdTo) == 0) {
                String syoriTimeFrom = uiBean.getSyoriTimeFrom();
                String syoriTimeTo = uiBean.getSyoriTimeTo();
                if (!Strings.isNullOrEmpty(syoriTimeFrom) && !Strings.isNullOrEmpty(syoriTimeTo)) {
                    if (syoriTimeFrom.compareTo(syoriTimeTo) > 0) {
                        throw new BizLogicException(MessageId.EAC0005, DDID_SEARCHCONDITIONS_SYORITIMEFROM,
                            DDID_SEARCHCONDITIONS_SYORITIMETO);
                    }
                }

            }
        }
    }

    private void chkSyoriYmdTimePartBlank() {
        if (uiBean.getSyoriYmdFrom() == null && !Strings.isNullOrEmpty(uiBean.getSyoriTimeFrom())) {
            throw new BizLogicException(MessageId.EAC0027, DDID_SEARCHCONDITIONS_SYORITIMEFROM,
                DDID_SEARCHCONDITIONS_SYORIYMDFROM);
        }

        if (uiBean.getSyoriYmdTo() == null && !Strings.isNullOrEmpty(uiBean.getSyoriTimeTo())) {
            throw new BizLogicException(MessageId.EAC0027, DDID_SEARCHCONDITIONS_SYORITIMETO,
                DDID_SEARCHCONDITIONS_SYORIYMDTO);
        }
    }

    private void setConversationMessage() {

        uiBean.setMaxShutokuKensu(String.valueOf(YuyuBaseConfig.getInstance().getMaxShutokuKensu()));

        messageManager.addConversationMessageId(MessageId.WAC0010, uiBean.getAccessLogInfoCount(),
            uiBean.getMaxShutokuKensu());
    }

}
