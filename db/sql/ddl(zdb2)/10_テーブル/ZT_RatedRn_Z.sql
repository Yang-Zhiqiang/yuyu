CREATE TABLE ZT_RatedRn_Z (
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分 */
     zrnyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予定利率 */
     zrnpmenkbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ免区分 */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分 */
     zrnhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別 */
     zrnkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）契約時被保険者年令 */
     zrnsaimnkkykhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）才満期契約表示 */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間 */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間 */
     zrndnendo                                          CHAR        (4)                                                       NOT NULL  ,  /* （連携用）Ｄ年度 */
     zrnnaiteikakuteikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｄレート内定確定区分 */
     zrndrate00                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート００ */
     zrndrate01                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０１ */
     zrndrate02                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０２ */
     zrndrate03                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０３ */
     zrndrate04                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０４ */
     zrndrate05                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０５ */
     zrndrate06                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０６ */
     zrndrate07                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０７ */
     zrndrate08                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０８ */
     zrndrate09                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０９ */
     zrndrate10                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１０ */
     zrndrate11                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１１ */
     zrndrate12                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１２ */
     zrndrate13                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１３ */
     zrndrate14                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１４ */
     zrndrate15                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１５ */
     zrndrate16                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１６ */
     zrndrate17                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１７ */
     zrndrate18                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１８ */
     zrndrate19                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１９ */
     zrndrate20                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２０ */
     zrndrate21                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２１ */
     zrndrate22                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２２ */
     zrndrate23                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２３ */
     zrndrate24                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２４ */
     zrndrate25                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２５ */
     zrndrate26                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２６ */
     zrndrate27                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２７ */
     zrndrate28                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２８ */
     zrndrate29                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２９ */
     zrndrate30                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３０ */
     zrndrate31                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３１ */
     zrndrate32                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３２ */
     zrndrate33                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３３ */
     zrndrate34                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３４ */
     zrndrate35                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３５ */
     zrndrate36                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３６ */
     zrndrate37                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３７ */
     zrndrate38                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３８ */
     zrndrate39                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３９ */
     zrndrate40                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４０ */
     zrndrate41                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４１ */
     zrndrate42                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４２ */
     zrndrate43                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４３ */
     zrndrate44                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４４ */
     zrndrate45                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４５ */
     zrndrate46                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４６ */
     zrndrate47                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４７ */
     zrndrate48                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４８ */
     zrndrate49                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４９ */
     zrndrate50                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５０ */
     zrndrate51                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５１ */
     zrndrate52                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５２ */
     zrndrate53                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５３ */
     zrndrate54                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５４ */
     zrndrate55                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５５ */
     zrndrate56                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５６ */
     zrndrate57                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５７ */
     zrndrate58                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５８ */
     zrndrate59                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５９ */
     zrndrate60                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６０ */
     zrndrate61                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６１ */
     zrndrate62                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６２ */
     zrndrate63                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６３ */
     zrndrate64                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６４ */
     zrndrate65                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６５ */
     zrndrate66                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６６ */
     zrndrate67                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６７ */
     zrndrate68                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６８ */
     zrndrate69                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６９ */
     zrndrate70                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７０ */
     zrndrate71                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７１ */
     zrndrate72                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７２ */
     zrndrate73                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７３ */
     zrndrate74                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７４ */
     zrndrate75                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７５ */
     zrndrate76                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７６ */
     zrndrate77                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７７ */
     zrndrate78                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７８ */
     zrndrate79                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７９ */
     zrndrate80                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８０ */
     zrndrate81                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８１ */
     zrndrate82                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８２ */
     zrndrate83                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８３ */
     zrndrate84                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８４ */
     zrndrate85                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８５ */
     zrndrate86                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８６ */
     zrndrate87                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８７ */
     zrndrate88                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８８ */
     zrndrate89                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８９ */
     zrndrate90                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９０ */
     zrndrate91                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９１ */
     zrndrate92                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９２ */
     zrndrate93                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９３ */
     zrndrate94                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９４ */
     zrndrate95                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９５ */
     zrndrate96                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９６ */
     zrndrate97                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９７ */
     zrndrate98                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９８ */
     zrndrate99                                         DECIMAL     (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９９ */
     zrnsisadrate00                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート００ */
     zrnsisadrate01                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート０１ */
     zrnsisadrate02                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート０２ */
     zrnsisadrate03                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート０３ */
     zrnsisadrate04                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート０４ */
     zrnsisadrate05                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート０５ */
     zrnsisadrate06                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート０６ */
     zrnsisadrate07                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート０７ */
     zrnsisadrate08                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート０８ */
     zrnsisadrate09                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート０９ */
     zrnsisadrate10                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート１０ */
     zrnsisadrate11                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート１１ */
     zrnsisadrate12                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート１２ */
     zrnsisadrate13                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート１３ */
     zrnsisadrate14                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート１４ */
     zrnsisadrate15                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート１５ */
     zrnsisadrate16                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート１６ */
     zrnsisadrate17                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート１７ */
     zrnsisadrate18                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート１８ */
     zrnsisadrate19                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート１９ */
     zrnsisadrate20                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート２０ */
     zrnsisadrate21                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート２１ */
     zrnsisadrate22                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート２２ */
     zrnsisadrate23                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート２３ */
     zrnsisadrate24                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート２４ */
     zrnsisadrate25                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート２５ */
     zrnsisadrate26                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート２６ */
     zrnsisadrate27                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート２７ */
     zrnsisadrate28                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート２８ */
     zrnsisadrate29                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート２９ */
     zrnsisadrate30                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート３０ */
     zrnsisadrate31                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート３１ */
     zrnsisadrate32                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート３２ */
     zrnsisadrate33                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート３３ */
     zrnsisadrate34                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート３４ */
     zrnsisadrate35                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート３５ */
     zrnsisadrate36                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート３６ */
     zrnsisadrate37                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート３７ */
     zrnsisadrate38                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート３８ */
     zrnsisadrate39                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート３９ */
     zrnsisadrate40                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート４０ */
     zrnsisadrate41                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート４１ */
     zrnsisadrate42                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート４２ */
     zrnsisadrate43                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート４３ */
     zrnsisadrate44                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート４４ */
     zrnsisadrate45                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート４５ */
     zrnsisadrate46                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート４６ */
     zrnsisadrate47                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート４７ */
     zrnsisadrate48                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート４８ */
     zrnsisadrate49                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート４９ */
     zrnsisadrate50                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート５０ */
     zrnsisadrate51                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート５１ */
     zrnsisadrate52                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート５２ */
     zrnsisadrate53                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート５３ */
     zrnsisadrate54                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート５４ */
     zrnsisadrate55                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート５５ */
     zrnsisadrate56                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート５６ */
     zrnsisadrate57                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート５７ */
     zrnsisadrate58                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート５８ */
     zrnsisadrate59                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート５９ */
     zrnsisadrate60                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート６０ */
     zrnsisadrate61                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート６１ */
     zrnsisadrate62                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート６２ */
     zrnsisadrate63                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート６３ */
     zrnsisadrate64                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート６４ */
     zrnsisadrate65                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート６５ */
     zrnsisadrate66                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート６６ */
     zrnsisadrate67                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート６７ */
     zrnsisadrate68                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート６８ */
     zrnsisadrate69                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート６９ */
     zrnsisadrate70                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート７０ */
     zrnsisadrate71                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート７１ */
     zrnsisadrate72                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート７２ */
     zrnsisadrate73                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート７３ */
     zrnsisadrate74                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート７４ */
     zrnsisadrate75                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート７５ */
     zrnsisadrate76                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート７６ */
     zrnsisadrate77                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート７７ */
     zrnsisadrate78                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート７８ */
     zrnsisadrate79                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート７９ */
     zrnsisadrate80                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート８０ */
     zrnsisadrate81                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート８１ */
     zrnsisadrate82                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート８２ */
     zrnsisadrate83                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート８３ */
     zrnsisadrate84                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート８４ */
     zrnsisadrate85                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート８５ */
     zrnsisadrate86                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート８６ */
     zrnsisadrate87                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート８７ */
     zrnsisadrate88                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート８８ */
     zrnsisadrate89                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート８９ */
     zrnsisadrate90                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート９０ */
     zrnsisadrate91                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート９１ */
     zrnsisadrate92                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート９２ */
     zrnsisadrate93                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート９３ */
     zrnsisadrate94                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート９４ */
     zrnsisadrate95                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート９５ */
     zrnsisadrate96                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート９６ */
     zrnsisadrate97                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート９７ */
     zrnsisadrate98                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート９８ */
     zrnsisadrate99                                     DECIMAL     (9,6)                                                               ,  /* （連携用）死差Ｄレート９９ */
     zrnrisadrate00                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート００ */
     zrnrisadrate01                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート０１ */
     zrnrisadrate02                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート０２ */
     zrnrisadrate03                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート０３ */
     zrnrisadrate04                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート０４ */
     zrnrisadrate05                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート０５ */
     zrnrisadrate06                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート０６ */
     zrnrisadrate07                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート０７ */
     zrnrisadrate08                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート０８ */
     zrnrisadrate09                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート０９ */
     zrnrisadrate10                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート１０ */
     zrnrisadrate11                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート１１ */
     zrnrisadrate12                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート１２ */
     zrnrisadrate13                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート１３ */
     zrnrisadrate14                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート１４ */
     zrnrisadrate15                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート１５ */
     zrnrisadrate16                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート１６ */
     zrnrisadrate17                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート１７ */
     zrnrisadrate18                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート１８ */
     zrnrisadrate19                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート１９ */
     zrnrisadrate20                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート２０ */
     zrnrisadrate21                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート２１ */
     zrnrisadrate22                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート２２ */
     zrnrisadrate23                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート２３ */
     zrnrisadrate24                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート２４ */
     zrnrisadrate25                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート２５ */
     zrnrisadrate26                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート２６ */
     zrnrisadrate27                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート２７ */
     zrnrisadrate28                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート２８ */
     zrnrisadrate29                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート２９ */
     zrnrisadrate30                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート３０ */
     zrnrisadrate31                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート３１ */
     zrnrisadrate32                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート３２ */
     zrnrisadrate33                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート３３ */
     zrnrisadrate34                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート３４ */
     zrnrisadrate35                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート３５ */
     zrnrisadrate36                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート３６ */
     zrnrisadrate37                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート３７ */
     zrnrisadrate38                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート３８ */
     zrnrisadrate39                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート３９ */
     zrnrisadrate40                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート４０ */
     zrnrisadrate41                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート４１ */
     zrnrisadrate42                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート４２ */
     zrnrisadrate43                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート４３ */
     zrnrisadrate44                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート４４ */
     zrnrisadrate45                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート４５ */
     zrnrisadrate46                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート４６ */
     zrnrisadrate47                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート４７ */
     zrnrisadrate48                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート４８ */
     zrnrisadrate49                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート４９ */
     zrnrisadrate50                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート５０ */
     zrnrisadrate51                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート５１ */
     zrnrisadrate52                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート５２ */
     zrnrisadrate53                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート５３ */
     zrnrisadrate54                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート５４ */
     zrnrisadrate55                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート５５ */
     zrnrisadrate56                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート５６ */
     zrnrisadrate57                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート５７ */
     zrnrisadrate58                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート５８ */
     zrnrisadrate59                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート５９ */
     zrnrisadrate60                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート６０ */
     zrnrisadrate61                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート６１ */
     zrnrisadrate62                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート６２ */
     zrnrisadrate63                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート６３ */
     zrnrisadrate64                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート６４ */
     zrnrisadrate65                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート６５ */
     zrnrisadrate66                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート６６ */
     zrnrisadrate67                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート６７ */
     zrnrisadrate68                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート６８ */
     zrnrisadrate69                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート６９ */
     zrnrisadrate70                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート７０ */
     zrnrisadrate71                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート７１ */
     zrnrisadrate72                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート７２ */
     zrnrisadrate73                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート７３ */
     zrnrisadrate74                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート７４ */
     zrnrisadrate75                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート７５ */
     zrnrisadrate76                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート７６ */
     zrnrisadrate77                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート７７ */
     zrnrisadrate78                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート７８ */
     zrnrisadrate79                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート７９ */
     zrnrisadrate80                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート８０ */
     zrnrisadrate81                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート８１ */
     zrnrisadrate82                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート８２ */
     zrnrisadrate83                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート８３ */
     zrnrisadrate84                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート８４ */
     zrnrisadrate85                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート８５ */
     zrnrisadrate86                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート８６ */
     zrnrisadrate87                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート８７ */
     zrnrisadrate88                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート８８ */
     zrnrisadrate89                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート８９ */
     zrnrisadrate90                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート９０ */
     zrnrisadrate91                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート９１ */
     zrnrisadrate92                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート９２ */
     zrnrisadrate93                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート９３ */
     zrnrisadrate94                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート９４ */
     zrnrisadrate95                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート９５ */
     zrnrisadrate96                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート９６ */
     zrnrisadrate97                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート９７ */
     zrnrisadrate98                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート９８ */
     zrnrisadrate99                                     DECIMAL     (9,6)                                                               ,  /* （連携用）利差Ｄレート９９ */
     zrnhisadrate00                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート００ */
     zrnhisadrate01                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート０１ */
     zrnhisadrate02                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート０２ */
     zrnhisadrate03                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート０３ */
     zrnhisadrate04                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート０４ */
     zrnhisadrate05                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート０５ */
     zrnhisadrate06                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート０６ */
     zrnhisadrate07                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート０７ */
     zrnhisadrate08                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート０８ */
     zrnhisadrate09                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート０９ */
     zrnhisadrate10                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート１０ */
     zrnhisadrate11                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート１１ */
     zrnhisadrate12                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート１２ */
     zrnhisadrate13                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート１３ */
     zrnhisadrate14                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート１４ */
     zrnhisadrate15                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート１５ */
     zrnhisadrate16                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート１６ */
     zrnhisadrate17                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート１７ */
     zrnhisadrate18                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート１８ */
     zrnhisadrate19                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート１９ */
     zrnhisadrate20                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート２０ */
     zrnhisadrate21                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート２１ */
     zrnhisadrate22                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート２２ */
     zrnhisadrate23                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート２３ */
     zrnhisadrate24                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート２４ */
     zrnhisadrate25                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート２５ */
     zrnhisadrate26                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート２６ */
     zrnhisadrate27                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート２７ */
     zrnhisadrate28                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート２８ */
     zrnhisadrate29                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート２９ */
     zrnhisadrate30                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート３０ */
     zrnhisadrate31                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート３１ */
     zrnhisadrate32                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート３２ */
     zrnhisadrate33                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート３３ */
     zrnhisadrate34                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート３４ */
     zrnhisadrate35                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート３５ */
     zrnhisadrate36                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート３６ */
     zrnhisadrate37                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート３７ */
     zrnhisadrate38                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート３８ */
     zrnhisadrate39                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート３９ */
     zrnhisadrate40                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート４０ */
     zrnhisadrate41                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート４１ */
     zrnhisadrate42                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート４２ */
     zrnhisadrate43                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート４３ */
     zrnhisadrate44                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート４４ */
     zrnhisadrate45                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート４５ */
     zrnhisadrate46                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート４６ */
     zrnhisadrate47                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート４７ */
     zrnhisadrate48                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート４８ */
     zrnhisadrate49                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート４９ */
     zrnhisadrate50                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート５０ */
     zrnhisadrate51                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート５１ */
     zrnhisadrate52                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート５２ */
     zrnhisadrate53                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート５３ */
     zrnhisadrate54                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート５４ */
     zrnhisadrate55                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート５５ */
     zrnhisadrate56                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート５６ */
     zrnhisadrate57                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート５７ */
     zrnhisadrate58                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート５８ */
     zrnhisadrate59                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート５９ */
     zrnhisadrate60                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート６０ */
     zrnhisadrate61                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート６１ */
     zrnhisadrate62                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート６２ */
     zrnhisadrate63                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート６３ */
     zrnhisadrate64                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート６４ */
     zrnhisadrate65                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート６５ */
     zrnhisadrate66                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート６６ */
     zrnhisadrate67                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート６７ */
     zrnhisadrate68                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート６８ */
     zrnhisadrate69                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート６９ */
     zrnhisadrate70                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート７０ */
     zrnhisadrate71                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート７１ */
     zrnhisadrate72                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート７２ */
     zrnhisadrate73                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート７３ */
     zrnhisadrate74                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート７４ */
     zrnhisadrate75                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート７５ */
     zrnhisadrate76                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート７６ */
     zrnhisadrate77                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート７７ */
     zrnhisadrate78                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート７８ */
     zrnhisadrate79                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート７９ */
     zrnhisadrate80                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート８０ */
     zrnhisadrate81                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート８１ */
     zrnhisadrate82                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート８２ */
     zrnhisadrate83                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート８３ */
     zrnhisadrate84                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート８４ */
     zrnhisadrate85                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート８５ */
     zrnhisadrate86                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート８６ */
     zrnhisadrate87                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート８７ */
     zrnhisadrate88                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート８８ */
     zrnhisadrate89                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート８９ */
     zrnhisadrate90                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート９０ */
     zrnhisadrate91                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート９１ */
     zrnhisadrate92                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート９２ */
     zrnhisadrate93                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート９３ */
     zrnhisadrate94                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート９４ */
     zrnhisadrate95                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート９５ */
     zrnhisadrate96                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート９６ */
     zrnhisadrate97                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート９７ */
     zrnhisadrate98                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート９８ */
     zrnhisadrate99                                     DECIMAL     (9,6)                                                               ,  /* （連携用）費差Ｄレート９９ */
     zrndyouvrate00                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート００ */
     zrndyouvrate01                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０１ */
     zrndyouvrate02                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０２ */
     zrndyouvrate03                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０３ */
     zrndyouvrate04                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０４ */
     zrndyouvrate05                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０５ */
     zrndyouvrate06                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０６ */
     zrndyouvrate07                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０７ */
     zrndyouvrate08                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０８ */
     zrndyouvrate09                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０９ */
     zrndyouvrate10                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１０ */
     zrndyouvrate11                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１１ */
     zrndyouvrate12                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１２ */
     zrndyouvrate13                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１３ */
     zrndyouvrate14                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１４ */
     zrndyouvrate15                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１５ */
     zrndyouvrate16                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１６ */
     zrndyouvrate17                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１７ */
     zrndyouvrate18                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１８ */
     zrndyouvrate19                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１９ */
     zrndyouvrate20                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２０ */
     zrndyouvrate21                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２１ */
     zrndyouvrate22                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２２ */
     zrndyouvrate23                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２３ */
     zrndyouvrate24                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２４ */
     zrndyouvrate25                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２５ */
     zrndyouvrate26                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２６ */
     zrndyouvrate27                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２７ */
     zrndyouvrate28                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２８ */
     zrndyouvrate29                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２９ */
     zrndyouvrate30                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３０ */
     zrndyouvrate31                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３１ */
     zrndyouvrate32                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３２ */
     zrndyouvrate33                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３３ */
     zrndyouvrate34                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３４ */
     zrndyouvrate35                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３５ */
     zrndyouvrate36                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３６ */
     zrndyouvrate37                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３７ */
     zrndyouvrate38                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３８ */
     zrndyouvrate39                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３９ */
     zrndyouvrate40                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４０ */
     zrndyouvrate41                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４１ */
     zrndyouvrate42                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４２ */
     zrndyouvrate43                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４３ */
     zrndyouvrate44                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４４ */
     zrndyouvrate45                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４５ */
     zrndyouvrate46                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４６ */
     zrndyouvrate47                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４７ */
     zrndyouvrate48                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４８ */
     zrndyouvrate49                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４９ */
     zrndyouvrate50                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５０ */
     zrndyouvrate51                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５１ */
     zrndyouvrate52                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５２ */
     zrndyouvrate53                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５３ */
     zrndyouvrate54                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５４ */
     zrndyouvrate55                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５５ */
     zrndyouvrate56                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５６ */
     zrndyouvrate57                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５７ */
     zrndyouvrate58                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５８ */
     zrndyouvrate59                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５９ */
     zrndyouvrate60                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６０ */
     zrndyouvrate61                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６１ */
     zrndyouvrate62                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６２ */
     zrndyouvrate63                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６３ */
     zrndyouvrate64                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６４ */
     zrndyouvrate65                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６５ */
     zrndyouvrate66                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６６ */
     zrndyouvrate67                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６７ */
     zrndyouvrate68                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６８ */
     zrndyouvrate69                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６９ */
     zrndyouvrate70                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７０ */
     zrndyouvrate71                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７１ */
     zrndyouvrate72                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７２ */
     zrndyouvrate73                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７３ */
     zrndyouvrate74                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７４ */
     zrndyouvrate75                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７５ */
     zrndyouvrate76                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７６ */
     zrndyouvrate77                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７７ */
     zrndyouvrate78                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７８ */
     zrndyouvrate79                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７９ */
     zrndyouvrate80                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８０ */
     zrndyouvrate81                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８１ */
     zrndyouvrate82                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８２ */
     zrndyouvrate83                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８３ */
     zrndyouvrate84                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８４ */
     zrndyouvrate85                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８５ */
     zrndyouvrate86                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８６ */
     zrndyouvrate87                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８７ */
     zrndyouvrate88                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８８ */
     zrndyouvrate89                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８９ */
     zrndyouvrate90                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９０ */
     zrndyouvrate91                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９１ */
     zrndyouvrate92                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９２ */
     zrndyouvrate93                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９３ */
     zrndyouvrate94                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９４ */
     zrndyouvrate95                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９５ */
     zrndyouvrate96                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９６ */
     zrndyouvrate97                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９７ */
     zrndyouvrate98                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９８ */
     zrndyouvrate99                                     DECIMAL     (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９９ */
     zrnkikensrate00                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート００ */
     zrnkikensrate01                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート０１ */
     zrnkikensrate02                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート０２ */
     zrnkikensrate03                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート０３ */
     zrnkikensrate04                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート０４ */
     zrnkikensrate05                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート０５ */
     zrnkikensrate06                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート０６ */
     zrnkikensrate07                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート０７ */
     zrnkikensrate08                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート０８ */
     zrnkikensrate09                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート０９ */
     zrnkikensrate10                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート１０ */
     zrnkikensrate11                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート１１ */
     zrnkikensrate12                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート１２ */
     zrnkikensrate13                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート１３ */
     zrnkikensrate14                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート１４ */
     zrnkikensrate15                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート１５ */
     zrnkikensrate16                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート１６ */
     zrnkikensrate17                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート１７ */
     zrnkikensrate18                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート１８ */
     zrnkikensrate19                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート１９ */
     zrnkikensrate20                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート２０ */
     zrnkikensrate21                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート２１ */
     zrnkikensrate22                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート２２ */
     zrnkikensrate23                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート２３ */
     zrnkikensrate24                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート２４ */
     zrnkikensrate25                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート２５ */
     zrnkikensrate26                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート２６ */
     zrnkikensrate27                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート２７ */
     zrnkikensrate28                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート２８ */
     zrnkikensrate29                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート２９ */
     zrnkikensrate30                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート３０ */
     zrnkikensrate31                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート３１ */
     zrnkikensrate32                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート３２ */
     zrnkikensrate33                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート３３ */
     zrnkikensrate34                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート３４ */
     zrnkikensrate35                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート３５ */
     zrnkikensrate36                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート３６ */
     zrnkikensrate37                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート３７ */
     zrnkikensrate38                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート３８ */
     zrnkikensrate39                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート３９ */
     zrnkikensrate40                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート４０ */
     zrnkikensrate41                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート４１ */
     zrnkikensrate42                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート４２ */
     zrnkikensrate43                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート４３ */
     zrnkikensrate44                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート４４ */
     zrnkikensrate45                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート４５ */
     zrnkikensrate46                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート４６ */
     zrnkikensrate47                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート４７ */
     zrnkikensrate48                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート４８ */
     zrnkikensrate49                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート４９ */
     zrnkikensrate50                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート５０ */
     zrnkikensrate51                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート５１ */
     zrnkikensrate52                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート５２ */
     zrnkikensrate53                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート５３ */
     zrnkikensrate54                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート５４ */
     zrnkikensrate55                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート５５ */
     zrnkikensrate56                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート５６ */
     zrnkikensrate57                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート５７ */
     zrnkikensrate58                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート５８ */
     zrnkikensrate59                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート５９ */
     zrnkikensrate60                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート６０ */
     zrnkikensrate61                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート６１ */
     zrnkikensrate62                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート６２ */
     zrnkikensrate63                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート６３ */
     zrnkikensrate64                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート６４ */
     zrnkikensrate65                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート６５ */
     zrnkikensrate66                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート６６ */
     zrnkikensrate67                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート６７ */
     zrnkikensrate68                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート６８ */
     zrnkikensrate69                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート６９ */
     zrnkikensrate70                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート７０ */
     zrnkikensrate71                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート７１ */
     zrnkikensrate72                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート７２ */
     zrnkikensrate73                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート７３ */
     zrnkikensrate74                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート７４ */
     zrnkikensrate75                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート７５ */
     zrnkikensrate76                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート７６ */
     zrnkikensrate77                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート７７ */
     zrnkikensrate78                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート７８ */
     zrnkikensrate79                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート７９ */
     zrnkikensrate80                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート８０ */
     zrnkikensrate81                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート８１ */
     zrnkikensrate82                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート８２ */
     zrnkikensrate83                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート８３ */
     zrnkikensrate84                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート８４ */
     zrnkikensrate85                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート８５ */
     zrnkikensrate86                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート８６ */
     zrnkikensrate87                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート８７ */
     zrnkikensrate88                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート８８ */
     zrnkikensrate89                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート８９ */
     zrnkikensrate90                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート９０ */
     zrnkikensrate91                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート９１ */
     zrnkikensrate92                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート９２ */
     zrnkikensrate93                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート９３ */
     zrnkikensrate94                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート９４ */
     zrnkikensrate95                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート９５ */
     zrnkikensrate96                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート９６ */
     zrnkikensrate97                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート９７ */
     zrnkikensrate98                                    DECIMAL     (9,6)                                                               ,  /* （連携用）危険Ｓレート９８ */
     zrnkikensrate99                                    DECIMAL     (9,6)                                                                  /* （連携用）危険Ｓレート９９ */
)
;

ALTER TABLE ZT_RatedRn_Z ADD CONSTRAINT PK_RatedRn PRIMARY KEY (
     zrnhknsyukigou                                           , /* （連携用）保険種類記号 */
     zrnhknsyuruikigousedaikbn                                , /* （連携用）保険種類記号世代区分 */
     zrnyoteiriritu                                           , /* （連携用）予定利率 */
     zrnpmenkbn                                               , /* （連携用）Ｐ免区分 */
     zrnhrkkaisuukbn                                          , /* （連携用）払込回数区分 */
     zrnhhknsei                                               , /* （連携用）被保険者性別 */
     zrnkeiyakujihhknnen                                      , /* （連携用）契約時被保険者年令 */
     zrnsaimnkkykhyj                                          , /* （連携用）才満期契約表示 */
     zrnhknkkn                                                , /* （連携用）保険期間 */
     zrnphrkkikn                                              , /* （連携用）Ｐ払込期間 */
     zrndnendo                                                , /* （連携用）Ｄ年度 */
     zrnnaiteikakuteikbn                                        /* （連携用）Ｄレート内定確定区分 */
) ;
