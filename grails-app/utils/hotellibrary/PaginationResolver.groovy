package hotellibrary

class PaginationResolver {

    static List<Integer> getListAvailablePages(int currentPage, int countPages, int countAvailablePages){
        List<Integer> availablePages = new ArrayList<>()
        int countLeftPages = (countAvailablePages + 1) / 2
        if (currentPage < countLeftPages){
            print countLeftPages
            for (int i = 0; i < countAvailablePages && i < countPages; i++){
                availablePages.add(i + 1)
            }
            return availablePages
        }
        if (countPages - currentPage < countAvailablePages){
            for (int i = countPages - countAvailablePages; i < countPages; i++){
                availablePages.add(i + 1)
            }
            return availablePages
        }
        for (int i = currentPage - countLeftPages + 1; i < currentPage + countLeftPages && i < countPages; i++){
            availablePages.add(i + 1)
        }
        return availablePages
    }
}
