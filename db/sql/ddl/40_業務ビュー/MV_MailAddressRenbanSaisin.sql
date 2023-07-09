CREATE VIEW MV_MailAddressRenbanSaisin AS SELECT
    t1.dskokno,                /* DS�ڋq�ԍ� */
    t1.dsmailaddressrenban,    /* DS���[���A�h���X�A�� */
    t2.kousinsyaId,            /* �X�V�҂h�c */
    t2.kousinTime,             /* �X�V���� */
    t2.kousinKinou,            /* �X�V�@�\ */
    t2.version                 /* �o�[�W���� */
FROM (
    SELECT 
        dskokno,                                           /* DS�ڋq�ԍ� */
        MAX(dsmailaddressrenban) AS dsmailaddressrenban    /* DS���[���A�h���X�A�Ԃ̍ő� */
    FROM MT_DsMailAddress 
    GROUP BY dskokno) t1
INNER JOIN (
    SELECT 
        dskokno,               /* DS�ڋq�ԍ� */
        dsmailaddressrenban,   /* DS���[���A�h���X�A�� */
        kousinsyaId,           /* �X�V�҂h�c */
        kousinTime,            /* �X�V���� */
        kousinKinou,           /* �X�V�@�\ */
        version                /* �o�[�W���� */
    FROM MT_DsMailAddress) t2
ON t1.dskokno = t2.dskokno 
AND t1.dsmailaddressrenban = t2.dsmailaddressrenban;