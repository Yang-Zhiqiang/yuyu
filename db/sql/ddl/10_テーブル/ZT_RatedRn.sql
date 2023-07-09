CREATE TABLE ZT_RatedRn (
     zrnhknsyukigou                                     CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険種類記号                                   */
     zrnhknsyuruikigousedaikbn                          CHAR        (1)                                                       NOT NULL  ,  /* （連携用）保険種類記号世代区分                               */
     zrnyoteiriritu                                     CHAR        (3)                                                       NOT NULL  ,  /* （連携用）予定利率                                     */
     zrnpmenkbn                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｐ免区分                                     */
     zrnhrkkaisuukbn                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）払込回数区分                                   */
     zrnhhknsei                                         CHAR        (1)                                                       NOT NULL  ,  /* （連携用）被保険者性別                                   */
     zrnkeiyakujihhknnen                                CHAR        (3)                                                       NOT NULL  ,  /* （連携用）契約時被保険者年令                                */
     zrnsaimnkkykhyj                                    CHAR        (1)                                                       NOT NULL  ,  /* （連携用）才満期契約表示                                  */
     zrnhknkkn                                          CHAR        (2)                                                       NOT NULL  ,  /* （連携用）保険期間                                     */
     zrnphrkkikn                                        CHAR        (2)                                                       NOT NULL  ,  /* （連携用）Ｐ払込期間                                    */
     zrndnendo                                          CHAR        (4)                                                       NOT NULL  ,  /* （連携用）Ｄ年度                                      */
     zrnnaiteikakuteikbn                                CHAR        (1)                                                       NOT NULL  ,  /* （連携用）Ｄレート内定確定区分                               */
     zrndrate00                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート００                                   */
     zrndrate01                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０１                                   */
     zrndrate02                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０２                                   */
     zrndrate03                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０３                                   */
     zrndrate04                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０４                                   */
     zrndrate05                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０５                                   */
     zrndrate06                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０６                                   */
     zrndrate07                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０７                                   */
     zrndrate08                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０８                                   */
     zrndrate09                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート０９                                   */
     zrndrate10                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１０                                   */
     zrndrate11                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１１                                   */
     zrndrate12                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１２                                   */
     zrndrate13                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１３                                   */
     zrndrate14                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１４                                   */
     zrndrate15                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１５                                   */
     zrndrate16                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１６                                   */
     zrndrate17                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１７                                   */
     zrndrate18                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１８                                   */
     zrndrate19                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート１９                                   */
     zrndrate20                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２０                                   */
     zrndrate21                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２１                                   */
     zrndrate22                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２２                                   */
     zrndrate23                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２３                                   */
     zrndrate24                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２４                                   */
     zrndrate25                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２５                                   */
     zrndrate26                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２６                                   */
     zrndrate27                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２７                                   */
     zrndrate28                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２８                                   */
     zrndrate29                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート２９                                   */
     zrndrate30                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３０                                   */
     zrndrate31                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３１                                   */
     zrndrate32                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３２                                   */
     zrndrate33                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３３                                   */
     zrndrate34                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３４                                   */
     zrndrate35                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３５                                   */
     zrndrate36                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３６                                   */
     zrndrate37                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３７                                   */
     zrndrate38                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３８                                   */
     zrndrate39                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート３９                                   */
     zrndrate40                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４０                                   */
     zrndrate41                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４１                                   */
     zrndrate42                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４２                                   */
     zrndrate43                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４３                                   */
     zrndrate44                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４４                                   */
     zrndrate45                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４５                                   */
     zrndrate46                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４６                                   */
     zrndrate47                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４７                                   */
     zrndrate48                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４８                                   */
     zrndrate49                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート４９                                   */
     zrndrate50                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５０                                   */
     zrndrate51                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５１                                   */
     zrndrate52                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５２                                   */
     zrndrate53                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５３                                   */
     zrndrate54                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５４                                   */
     zrndrate55                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５５                                   */
     zrndrate56                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５６                                   */
     zrndrate57                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５７                                   */
     zrndrate58                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５８                                   */
     zrndrate59                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート５９                                   */
     zrndrate60                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６０                                   */
     zrndrate61                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６１                                   */
     zrndrate62                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６２                                   */
     zrndrate63                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６３                                   */
     zrndrate64                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６４                                   */
     zrndrate65                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６５                                   */
     zrndrate66                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６６                                   */
     zrndrate67                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６７                                   */
     zrndrate68                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６８                                   */
     zrndrate69                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート６９                                   */
     zrndrate70                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７０                                   */
     zrndrate71                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７１                                   */
     zrndrate72                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７２                                   */
     zrndrate73                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７３                                   */
     zrndrate74                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７４                                   */
     zrndrate75                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７５                                   */
     zrndrate76                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７６                                   */
     zrndrate77                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７７                                   */
     zrndrate78                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７８                                   */
     zrndrate79                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート７９                                   */
     zrndrate80                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８０                                   */
     zrndrate81                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８１                                   */
     zrndrate82                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８２                                   */
     zrndrate83                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８３                                   */
     zrndrate84                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８４                                   */
     zrndrate85                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８５                                   */
     zrndrate86                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８６                                   */
     zrndrate87                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８７                                   */
     zrndrate88                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８８                                   */
     zrndrate89                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート８９                                   */
     zrndrate90                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９０                                   */
     zrndrate91                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９１                                   */
     zrndrate92                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９２                                   */
     zrndrate93                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９３                                   */
     zrndrate94                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９４                                   */
     zrndrate95                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９５                                   */
     zrndrate96                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９６                                   */
     zrndrate97                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９７                                   */
     zrndrate98                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９８                                   */
     zrndrate99                                         NUMBER      (9,6)                                                     NOT NULL  ,  /* （連携用）Ｄレート９９                                   */
     zrnsisadrate00                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート００                                 */
     zrnsisadrate01                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート０１                                 */
     zrnsisadrate02                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート０２                                 */
     zrnsisadrate03                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート０３                                 */
     zrnsisadrate04                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート０４                                 */
     zrnsisadrate05                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート０５                                 */
     zrnsisadrate06                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート０６                                 */
     zrnsisadrate07                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート０７                                 */
     zrnsisadrate08                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート０８                                 */
     zrnsisadrate09                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート０９                                 */
     zrnsisadrate10                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート１０                                 */
     zrnsisadrate11                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート１１                                 */
     zrnsisadrate12                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート１２                                 */
     zrnsisadrate13                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート１３                                 */
     zrnsisadrate14                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート１４                                 */
     zrnsisadrate15                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート１５                                 */
     zrnsisadrate16                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート１６                                 */
     zrnsisadrate17                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート１７                                 */
     zrnsisadrate18                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート１８                                 */
     zrnsisadrate19                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート１９                                 */
     zrnsisadrate20                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート２０                                 */
     zrnsisadrate21                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート２１                                 */
     zrnsisadrate22                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート２２                                 */
     zrnsisadrate23                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート２３                                 */
     zrnsisadrate24                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート２４                                 */
     zrnsisadrate25                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート２５                                 */
     zrnsisadrate26                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート２６                                 */
     zrnsisadrate27                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート２７                                 */
     zrnsisadrate28                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート２８                                 */
     zrnsisadrate29                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート２９                                 */
     zrnsisadrate30                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート３０                                 */
     zrnsisadrate31                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート３１                                 */
     zrnsisadrate32                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート３２                                 */
     zrnsisadrate33                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート３３                                 */
     zrnsisadrate34                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート３４                                 */
     zrnsisadrate35                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート３５                                 */
     zrnsisadrate36                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート３６                                 */
     zrnsisadrate37                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート３７                                 */
     zrnsisadrate38                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート３８                                 */
     zrnsisadrate39                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート３９                                 */
     zrnsisadrate40                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート４０                                 */
     zrnsisadrate41                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート４１                                 */
     zrnsisadrate42                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート４２                                 */
     zrnsisadrate43                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート４３                                 */
     zrnsisadrate44                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート４４                                 */
     zrnsisadrate45                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート４５                                 */
     zrnsisadrate46                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート４６                                 */
     zrnsisadrate47                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート４７                                 */
     zrnsisadrate48                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート４８                                 */
     zrnsisadrate49                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート４９                                 */
     zrnsisadrate50                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート５０                                 */
     zrnsisadrate51                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート５１                                 */
     zrnsisadrate52                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート５２                                 */
     zrnsisadrate53                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート５３                                 */
     zrnsisadrate54                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート５４                                 */
     zrnsisadrate55                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート５５                                 */
     zrnsisadrate56                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート５６                                 */
     zrnsisadrate57                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート５７                                 */
     zrnsisadrate58                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート５８                                 */
     zrnsisadrate59                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート５９                                 */
     zrnsisadrate60                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート６０                                 */
     zrnsisadrate61                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート６１                                 */
     zrnsisadrate62                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート６２                                 */
     zrnsisadrate63                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート６３                                 */
     zrnsisadrate64                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート６４                                 */
     zrnsisadrate65                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート６５                                 */
     zrnsisadrate66                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート６６                                 */
     zrnsisadrate67                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート６７                                 */
     zrnsisadrate68                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート６８                                 */
     zrnsisadrate69                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート６９                                 */
     zrnsisadrate70                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート７０                                 */
     zrnsisadrate71                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート７１                                 */
     zrnsisadrate72                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート７２                                 */
     zrnsisadrate73                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート７３                                 */
     zrnsisadrate74                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート７４                                 */
     zrnsisadrate75                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート７５                                 */
     zrnsisadrate76                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート７６                                 */
     zrnsisadrate77                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート７７                                 */
     zrnsisadrate78                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート７８                                 */
     zrnsisadrate79                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート７９                                 */
     zrnsisadrate80                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート８０                                 */
     zrnsisadrate81                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート８１                                 */
     zrnsisadrate82                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート８２                                 */
     zrnsisadrate83                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート８３                                 */
     zrnsisadrate84                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート８４                                 */
     zrnsisadrate85                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート８５                                 */
     zrnsisadrate86                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート８６                                 */
     zrnsisadrate87                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート８７                                 */
     zrnsisadrate88                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート８８                                 */
     zrnsisadrate89                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート８９                                 */
     zrnsisadrate90                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート９０                                 */
     zrnsisadrate91                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート９１                                 */
     zrnsisadrate92                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート９２                                 */
     zrnsisadrate93                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート９３                                 */
     zrnsisadrate94                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート９４                                 */
     zrnsisadrate95                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート９５                                 */
     zrnsisadrate96                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート９６                                 */
     zrnsisadrate97                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート９７                                 */
     zrnsisadrate98                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート９８                                 */
     zrnsisadrate99                                     NUMBER      (9,6)                                                               ,  /* （連携用）死差Ｄレート９９                                 */
     zrnrisadrate00                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート００                                 */
     zrnrisadrate01                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート０１                                 */
     zrnrisadrate02                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート０２                                 */
     zrnrisadrate03                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート０３                                 */
     zrnrisadrate04                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート０４                                 */
     zrnrisadrate05                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート０５                                 */
     zrnrisadrate06                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート０６                                 */
     zrnrisadrate07                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート０７                                 */
     zrnrisadrate08                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート０８                                 */
     zrnrisadrate09                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート０９                                 */
     zrnrisadrate10                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート１０                                 */
     zrnrisadrate11                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート１１                                 */
     zrnrisadrate12                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート１２                                 */
     zrnrisadrate13                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート１３                                 */
     zrnrisadrate14                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート１４                                 */
     zrnrisadrate15                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート１５                                 */
     zrnrisadrate16                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート１６                                 */
     zrnrisadrate17                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート１７                                 */
     zrnrisadrate18                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート１８                                 */
     zrnrisadrate19                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート１９                                 */
     zrnrisadrate20                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート２０                                 */
     zrnrisadrate21                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート２１                                 */
     zrnrisadrate22                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート２２                                 */
     zrnrisadrate23                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート２３                                 */
     zrnrisadrate24                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート２４                                 */
     zrnrisadrate25                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート２５                                 */
     zrnrisadrate26                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート２６                                 */
     zrnrisadrate27                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート２７                                 */
     zrnrisadrate28                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート２８                                 */
     zrnrisadrate29                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート２９                                 */
     zrnrisadrate30                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート３０                                 */
     zrnrisadrate31                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート３１                                 */
     zrnrisadrate32                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート３２                                 */
     zrnrisadrate33                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート３３                                 */
     zrnrisadrate34                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート３４                                 */
     zrnrisadrate35                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート３５                                 */
     zrnrisadrate36                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート３６                                 */
     zrnrisadrate37                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート３７                                 */
     zrnrisadrate38                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート３８                                 */
     zrnrisadrate39                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート３９                                 */
     zrnrisadrate40                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート４０                                 */
     zrnrisadrate41                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート４１                                 */
     zrnrisadrate42                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート４２                                 */
     zrnrisadrate43                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート４３                                 */
     zrnrisadrate44                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート４４                                 */
     zrnrisadrate45                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート４５                                 */
     zrnrisadrate46                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート４６                                 */
     zrnrisadrate47                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート４７                                 */
     zrnrisadrate48                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート４８                                 */
     zrnrisadrate49                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート４９                                 */
     zrnrisadrate50                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート５０                                 */
     zrnrisadrate51                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート５１                                 */
     zrnrisadrate52                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート５２                                 */
     zrnrisadrate53                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート５３                                 */
     zrnrisadrate54                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート５４                                 */
     zrnrisadrate55                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート５５                                 */
     zrnrisadrate56                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート５６                                 */
     zrnrisadrate57                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート５７                                 */
     zrnrisadrate58                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート５８                                 */
     zrnrisadrate59                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート５９                                 */
     zrnrisadrate60                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート６０                                 */
     zrnrisadrate61                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート６１                                 */
     zrnrisadrate62                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート６２                                 */
     zrnrisadrate63                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート６３                                 */
     zrnrisadrate64                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート６４                                 */
     zrnrisadrate65                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート６５                                 */
     zrnrisadrate66                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート６６                                 */
     zrnrisadrate67                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート６７                                 */
     zrnrisadrate68                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート６８                                 */
     zrnrisadrate69                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート６９                                 */
     zrnrisadrate70                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート７０                                 */
     zrnrisadrate71                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート７１                                 */
     zrnrisadrate72                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート７２                                 */
     zrnrisadrate73                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート７３                                 */
     zrnrisadrate74                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート７４                                 */
     zrnrisadrate75                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート７５                                 */
     zrnrisadrate76                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート７６                                 */
     zrnrisadrate77                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート７７                                 */
     zrnrisadrate78                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート７８                                 */
     zrnrisadrate79                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート７９                                 */
     zrnrisadrate80                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート８０                                 */
     zrnrisadrate81                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート８１                                 */
     zrnrisadrate82                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート８２                                 */
     zrnrisadrate83                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート８３                                 */
     zrnrisadrate84                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート８４                                 */
     zrnrisadrate85                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート８５                                 */
     zrnrisadrate86                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート８６                                 */
     zrnrisadrate87                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート８７                                 */
     zrnrisadrate88                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート８８                                 */
     zrnrisadrate89                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート８９                                 */
     zrnrisadrate90                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート９０                                 */
     zrnrisadrate91                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート９１                                 */
     zrnrisadrate92                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート９２                                 */
     zrnrisadrate93                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート９３                                 */
     zrnrisadrate94                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート９４                                 */
     zrnrisadrate95                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート９５                                 */
     zrnrisadrate96                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート９６                                 */
     zrnrisadrate97                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート９７                                 */
     zrnrisadrate98                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート９８                                 */
     zrnrisadrate99                                     NUMBER      (9,6)                                                               ,  /* （連携用）利差Ｄレート９９                                 */
     zrnhisadrate00                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート００                                 */
     zrnhisadrate01                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート０１                                 */
     zrnhisadrate02                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート０２                                 */
     zrnhisadrate03                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート０３                                 */
     zrnhisadrate04                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート０４                                 */
     zrnhisadrate05                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート０５                                 */
     zrnhisadrate06                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート０６                                 */
     zrnhisadrate07                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート０７                                 */
     zrnhisadrate08                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート０８                                 */
     zrnhisadrate09                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート０９                                 */
     zrnhisadrate10                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート１０                                 */
     zrnhisadrate11                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート１１                                 */
     zrnhisadrate12                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート１２                                 */
     zrnhisadrate13                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート１３                                 */
     zrnhisadrate14                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート１４                                 */
     zrnhisadrate15                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート１５                                 */
     zrnhisadrate16                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート１６                                 */
     zrnhisadrate17                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート１７                                 */
     zrnhisadrate18                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート１８                                 */
     zrnhisadrate19                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート１９                                 */
     zrnhisadrate20                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート２０                                 */
     zrnhisadrate21                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート２１                                 */
     zrnhisadrate22                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート２２                                 */
     zrnhisadrate23                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート２３                                 */
     zrnhisadrate24                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート２４                                 */
     zrnhisadrate25                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート２５                                 */
     zrnhisadrate26                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート２６                                 */
     zrnhisadrate27                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート２７                                 */
     zrnhisadrate28                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート２８                                 */
     zrnhisadrate29                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート２９                                 */
     zrnhisadrate30                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート３０                                 */
     zrnhisadrate31                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート３１                                 */
     zrnhisadrate32                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート３２                                 */
     zrnhisadrate33                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート３３                                 */
     zrnhisadrate34                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート３４                                 */
     zrnhisadrate35                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート３５                                 */
     zrnhisadrate36                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート３６                                 */
     zrnhisadrate37                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート３７                                 */
     zrnhisadrate38                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート３８                                 */
     zrnhisadrate39                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート３９                                 */
     zrnhisadrate40                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート４０                                 */
     zrnhisadrate41                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート４１                                 */
     zrnhisadrate42                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート４２                                 */
     zrnhisadrate43                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート４３                                 */
     zrnhisadrate44                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート４４                                 */
     zrnhisadrate45                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート４５                                 */
     zrnhisadrate46                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート４６                                 */
     zrnhisadrate47                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート４７                                 */
     zrnhisadrate48                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート４８                                 */
     zrnhisadrate49                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート４９                                 */
     zrnhisadrate50                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート５０                                 */
     zrnhisadrate51                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート５１                                 */
     zrnhisadrate52                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート５２                                 */
     zrnhisadrate53                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート５３                                 */
     zrnhisadrate54                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート５４                                 */
     zrnhisadrate55                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート５５                                 */
     zrnhisadrate56                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート５６                                 */
     zrnhisadrate57                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート５７                                 */
     zrnhisadrate58                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート５８                                 */
     zrnhisadrate59                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート５９                                 */
     zrnhisadrate60                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート６０                                 */
     zrnhisadrate61                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート６１                                 */
     zrnhisadrate62                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート６２                                 */
     zrnhisadrate63                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート６３                                 */
     zrnhisadrate64                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート６４                                 */
     zrnhisadrate65                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート６５                                 */
     zrnhisadrate66                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート６６                                 */
     zrnhisadrate67                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート６７                                 */
     zrnhisadrate68                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート６８                                 */
     zrnhisadrate69                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート６９                                 */
     zrnhisadrate70                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート７０                                 */
     zrnhisadrate71                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート７１                                 */
     zrnhisadrate72                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート７２                                 */
     zrnhisadrate73                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート７３                                 */
     zrnhisadrate74                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート７４                                 */
     zrnhisadrate75                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート７５                                 */
     zrnhisadrate76                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート７６                                 */
     zrnhisadrate77                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート７７                                 */
     zrnhisadrate78                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート７８                                 */
     zrnhisadrate79                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート７９                                 */
     zrnhisadrate80                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート８０                                 */
     zrnhisadrate81                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート８１                                 */
     zrnhisadrate82                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート８２                                 */
     zrnhisadrate83                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート８３                                 */
     zrnhisadrate84                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート８４                                 */
     zrnhisadrate85                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート８５                                 */
     zrnhisadrate86                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート８６                                 */
     zrnhisadrate87                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート８７                                 */
     zrnhisadrate88                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート８８                                 */
     zrnhisadrate89                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート８９                                 */
     zrnhisadrate90                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート９０                                 */
     zrnhisadrate91                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート９１                                 */
     zrnhisadrate92                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート９２                                 */
     zrnhisadrate93                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート９３                                 */
     zrnhisadrate94                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート９４                                 */
     zrnhisadrate95                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート９５                                 */
     zrnhisadrate96                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート９６                                 */
     zrnhisadrate97                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート９７                                 */
     zrnhisadrate98                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート９８                                 */
     zrnhisadrate99                                     NUMBER      (9,6)                                                               ,  /* （連携用）費差Ｄレート９９                                 */
     zrndyouvrate00                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート００                                 */
     zrndyouvrate01                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０１                                 */
     zrndyouvrate02                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０２                                 */
     zrndyouvrate03                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０３                                 */
     zrndyouvrate04                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０４                                 */
     zrndyouvrate05                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０５                                 */
     zrndyouvrate06                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０６                                 */
     zrndyouvrate07                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０７                                 */
     zrndyouvrate08                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０８                                 */
     zrndyouvrate09                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート０９                                 */
     zrndyouvrate10                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１０                                 */
     zrndyouvrate11                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１１                                 */
     zrndyouvrate12                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１２                                 */
     zrndyouvrate13                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１３                                 */
     zrndyouvrate14                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１４                                 */
     zrndyouvrate15                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１５                                 */
     zrndyouvrate16                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１６                                 */
     zrndyouvrate17                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１７                                 */
     zrndyouvrate18                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１８                                 */
     zrndyouvrate19                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート１９                                 */
     zrndyouvrate20                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２０                                 */
     zrndyouvrate21                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２１                                 */
     zrndyouvrate22                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２２                                 */
     zrndyouvrate23                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２３                                 */
     zrndyouvrate24                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２４                                 */
     zrndyouvrate25                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２５                                 */
     zrndyouvrate26                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２６                                 */
     zrndyouvrate27                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２７                                 */
     zrndyouvrate28                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２８                                 */
     zrndyouvrate29                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート２９                                 */
     zrndyouvrate30                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３０                                 */
     zrndyouvrate31                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３１                                 */
     zrndyouvrate32                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３２                                 */
     zrndyouvrate33                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３３                                 */
     zrndyouvrate34                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３４                                 */
     zrndyouvrate35                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３５                                 */
     zrndyouvrate36                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３６                                 */
     zrndyouvrate37                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３７                                 */
     zrndyouvrate38                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３８                                 */
     zrndyouvrate39                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート３９                                 */
     zrndyouvrate40                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４０                                 */
     zrndyouvrate41                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４１                                 */
     zrndyouvrate42                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４２                                 */
     zrndyouvrate43                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４３                                 */
     zrndyouvrate44                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４４                                 */
     zrndyouvrate45                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４５                                 */
     zrndyouvrate46                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４６                                 */
     zrndyouvrate47                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４７                                 */
     zrndyouvrate48                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４８                                 */
     zrndyouvrate49                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート４９                                 */
     zrndyouvrate50                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５０                                 */
     zrndyouvrate51                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５１                                 */
     zrndyouvrate52                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５２                                 */
     zrndyouvrate53                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５３                                 */
     zrndyouvrate54                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５４                                 */
     zrndyouvrate55                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５５                                 */
     zrndyouvrate56                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５６                                 */
     zrndyouvrate57                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５７                                 */
     zrndyouvrate58                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５８                                 */
     zrndyouvrate59                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート５９                                 */
     zrndyouvrate60                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６０                                 */
     zrndyouvrate61                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６１                                 */
     zrndyouvrate62                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６２                                 */
     zrndyouvrate63                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６３                                 */
     zrndyouvrate64                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６４                                 */
     zrndyouvrate65                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６５                                 */
     zrndyouvrate66                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６６                                 */
     zrndyouvrate67                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６７                                 */
     zrndyouvrate68                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６８                                 */
     zrndyouvrate69                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート６９                                 */
     zrndyouvrate70                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７０                                 */
     zrndyouvrate71                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７１                                 */
     zrndyouvrate72                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７２                                 */
     zrndyouvrate73                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７３                                 */
     zrndyouvrate74                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７４                                 */
     zrndyouvrate75                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７５                                 */
     zrndyouvrate76                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７６                                 */
     zrndyouvrate77                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７７                                 */
     zrndyouvrate78                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７８                                 */
     zrndyouvrate79                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート７９                                 */
     zrndyouvrate80                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８０                                 */
     zrndyouvrate81                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８１                                 */
     zrndyouvrate82                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８２                                 */
     zrndyouvrate83                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８３                                 */
     zrndyouvrate84                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８４                                 */
     zrndyouvrate85                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８５                                 */
     zrndyouvrate86                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８６                                 */
     zrndyouvrate87                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８７                                 */
     zrndyouvrate88                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８８                                 */
     zrndyouvrate89                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート８９                                 */
     zrndyouvrate90                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９０                                 */
     zrndyouvrate91                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９１                                 */
     zrndyouvrate92                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９２                                 */
     zrndyouvrate93                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９３                                 */
     zrndyouvrate94                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９４                                 */
     zrndyouvrate95                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９５                                 */
     zrndyouvrate96                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９６                                 */
     zrndyouvrate97                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９７                                 */
     zrndyouvrate98                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９８                                 */
     zrndyouvrate99                                     NUMBER      (9,6)                                                               ,  /* （連携用）Ｄ用Ｖレート９９                                 */
     zrnkikensrate00                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート００                                 */
     zrnkikensrate01                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート０１                                 */
     zrnkikensrate02                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート０２                                 */
     zrnkikensrate03                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート０３                                 */
     zrnkikensrate04                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート０４                                 */
     zrnkikensrate05                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート０５                                 */
     zrnkikensrate06                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート０６                                 */
     zrnkikensrate07                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート０７                                 */
     zrnkikensrate08                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート０８                                 */
     zrnkikensrate09                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート０９                                 */
     zrnkikensrate10                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート１０                                 */
     zrnkikensrate11                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート１１                                 */
     zrnkikensrate12                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート１２                                 */
     zrnkikensrate13                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート１３                                 */
     zrnkikensrate14                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート１４                                 */
     zrnkikensrate15                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート１５                                 */
     zrnkikensrate16                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート１６                                 */
     zrnkikensrate17                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート１７                                 */
     zrnkikensrate18                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート１８                                 */
     zrnkikensrate19                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート１９                                 */
     zrnkikensrate20                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート２０                                 */
     zrnkikensrate21                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート２１                                 */
     zrnkikensrate22                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート２２                                 */
     zrnkikensrate23                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート２３                                 */
     zrnkikensrate24                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート２４                                 */
     zrnkikensrate25                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート２５                                 */
     zrnkikensrate26                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート２６                                 */
     zrnkikensrate27                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート２７                                 */
     zrnkikensrate28                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート２８                                 */
     zrnkikensrate29                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート２９                                 */
     zrnkikensrate30                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート３０                                 */
     zrnkikensrate31                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート３１                                 */
     zrnkikensrate32                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート３２                                 */
     zrnkikensrate33                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート３３                                 */
     zrnkikensrate34                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート３４                                 */
     zrnkikensrate35                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート３５                                 */
     zrnkikensrate36                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート３６                                 */
     zrnkikensrate37                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート３７                                 */
     zrnkikensrate38                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート３８                                 */
     zrnkikensrate39                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート３９                                 */
     zrnkikensrate40                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート４０                                 */
     zrnkikensrate41                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート４１                                 */
     zrnkikensrate42                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート４２                                 */
     zrnkikensrate43                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート４３                                 */
     zrnkikensrate44                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート４４                                 */
     zrnkikensrate45                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート４５                                 */
     zrnkikensrate46                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート４６                                 */
     zrnkikensrate47                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート４７                                 */
     zrnkikensrate48                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート４８                                 */
     zrnkikensrate49                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート４９                                 */
     zrnkikensrate50                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート５０                                 */
     zrnkikensrate51                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート５１                                 */
     zrnkikensrate52                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート５２                                 */
     zrnkikensrate53                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート５３                                 */
     zrnkikensrate54                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート５４                                 */
     zrnkikensrate55                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート５５                                 */
     zrnkikensrate56                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート５６                                 */
     zrnkikensrate57                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート５７                                 */
     zrnkikensrate58                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート５８                                 */
     zrnkikensrate59                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート５９                                 */
     zrnkikensrate60                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート６０                                 */
     zrnkikensrate61                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート６１                                 */
     zrnkikensrate62                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート６２                                 */
     zrnkikensrate63                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート６３                                 */
     zrnkikensrate64                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート６４                                 */
     zrnkikensrate65                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート６５                                 */
     zrnkikensrate66                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート６６                                 */
     zrnkikensrate67                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート６７                                 */
     zrnkikensrate68                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート６８                                 */
     zrnkikensrate69                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート６９                                 */
     zrnkikensrate70                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート７０                                 */
     zrnkikensrate71                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート７１                                 */
     zrnkikensrate72                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート７２                                 */
     zrnkikensrate73                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート７３                                 */
     zrnkikensrate74                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート７４                                 */
     zrnkikensrate75                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート７５                                 */
     zrnkikensrate76                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート７６                                 */
     zrnkikensrate77                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート７７                                 */
     zrnkikensrate78                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート７８                                 */
     zrnkikensrate79                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート７９                                 */
     zrnkikensrate80                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート８０                                 */
     zrnkikensrate81                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート８１                                 */
     zrnkikensrate82                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート８２                                 */
     zrnkikensrate83                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート８３                                 */
     zrnkikensrate84                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート８４                                 */
     zrnkikensrate85                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート８５                                 */
     zrnkikensrate86                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート８６                                 */
     zrnkikensrate87                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート８７                                 */
     zrnkikensrate88                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート８８                                 */
     zrnkikensrate89                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート８９                                 */
     zrnkikensrate90                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート９０                                 */
     zrnkikensrate91                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート９１                                 */
     zrnkikensrate92                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート９２                                 */
     zrnkikensrate93                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート９３                                 */
     zrnkikensrate94                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート９４                                 */
     zrnkikensrate95                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート９５                                 */
     zrnkikensrate96                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート９６                                 */
     zrnkikensrate97                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート９７                                 */
     zrnkikensrate98                                    NUMBER      (9,6)                                                               ,  /* （連携用）危険Ｓレート９８                                 */
     zrnkikensrate99                                    NUMBER      (9,6)                                                                  /* （連携用）危険Ｓレート９９                                 */
)
;

ALTER TABLE ZT_RatedRn ADD CONSTRAINT PK_RatedRn PRIMARY KEY (
     zrnhknsyukigou                                           , /* （連携用）保険種類記号                                    */
     zrnhknsyuruikigousedaikbn                                , /* （連携用）保険種類記号世代区分                                */
     zrnyoteiriritu                                           , /* （連携用）予定利率                                      */
     zrnpmenkbn                                               , /* （連携用）Ｐ免区分                                      */
     zrnhrkkaisuukbn                                          , /* （連携用）払込回数区分                                    */
     zrnhhknsei                                               , /* （連携用）被保険者性別                                    */
     zrnkeiyakujihhknnen                                      , /* （連携用）契約時被保険者年令                                 */
     zrnsaimnkkykhyj                                          , /* （連携用）才満期契約表示                                   */
     zrnhknkkn                                                , /* （連携用）保険期間                                      */
     zrnphrkkikn                                              , /* （連携用）Ｐ払込期間                                     */
     zrndnendo                                                , /* （連携用）Ｄ年度                                       */
     zrnnaiteikakuteikbn                                        /* （連携用）Ｄレート内定確定区分                                */
) ;
