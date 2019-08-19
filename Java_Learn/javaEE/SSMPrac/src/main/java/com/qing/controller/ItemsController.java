package com.qing.controller;

import com.qing.po.Items;
import com.qing.po.ItemsCustom;
import com.qing.po.ItemsVO;
import com.qing.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Classname ItemsController
 * @Description TODO
 * @Date 2019/8/18 19:56
 * @Created by AppleTree
 */

@Controller
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    //商品列表查询
    @RequestMapping(value = "/queryitemsbyname")
    public ModelAndView queryItemsList(HttpServletResponse response, ItemsVO itemsVO) throws Exception{
        response.setContentType("text/html;charset=UTF-8");

        List<ItemsCustom> itemsCustomList =  itemsService.queryItemsByNameService(itemsVO);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsListKey",itemsCustomList);
        modelAndView.setViewName("itemsList");
        return modelAndView;
    }
    //使方法仅仅返回void， 也同样可以实现修改或者查询

    /**
     * How do I to do it?
     * @param
     * @param
     * @return
     * @throws Exception
     * doGet/doPost
     */
    @RequestMapping(value = "/queryItemsList2")
    public void queryItensList2(HttpServletRequest request,
                                HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        /**
         * think about it how do you to do it?
         */
        List<ItemsCustom> itemsCustomList =  itemsService.queryItemsByNameService(null);
        request.setAttribute("itemsListKey",itemsCustomList);
        request.getRequestDispatcher("/jsp/itemsList.jsp").forward(request,response);
        //response.sendRedirect();
    }


    //商品修改信息展示
    @RequestMapping(value = "/modifyInfoShow")
    public String modifyInfoShow(Model model, HttpServletRequest request,
                                 HttpServletResponse response) throws  Exception{
        response.setContentType("text/html;charset=UTF-8");

        Items items;
        String linkId = request.getParameter("id");

        if(linkId == null){
            String strId = request.getParameter("selItem");
            int checkBoxId = Integer.parseInt(strId);
            items = itemsService.queryItemsById(checkBoxId);
        }else{
            int linkId_int = Integer.parseInt(linkId);
            items = itemsService.queryItemsById(linkId_int);
        }
        model.addAttribute("itemsKey", items);
        return "edit";
    }

    /**
     * 真正的去修改
     * @return
     */
    @RequestMapping(value = "/editSubmit")
    public String modifyInfoSubmit(Integer id,Items items,HttpServletRequest request,HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        String myId = request.getParameter("id");
        System.out.println("myId = " + myId);
        itemsService.modifyItems(id,items);
        //return "redirect:queryitemsbyname.action";
        return "redirect:multis.action";
        //return "forward:queryitemsbyname.action";
        //return null;

    }

    //添加查询: 去添加页面
    @RequestMapping(value = "/addItems")
    public String addItesmController(){
        // how do I to do it?
        return "redirect:/jsp/addItems.jsp";
    }

    //添加查询: 添加
    //参数绑定
    @RequestMapping(value = "/addItemsOperator")
    public void addItesmController1(HttpServletRequest request,
                                    HttpServletResponse response) throws Exception{

        response.setContentType("text/html;charset=UTF-8");

        String myFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myFormat);
        String strDate = request.getParameter("itemsTime");
        Date myDate = simpleDateFormat.parse(strDate);
        ItemsCustom itemsCustom = new ItemsCustom();
        itemsCustom.setName(request.getParameter("itemsName"));
        itemsCustom.setPrice(Float.valueOf(request.getParameter("itemsPrice")));
        itemsCustom.setCreatetime(myDate);
        itemsCustom.setDetail(request.getParameter("itemsInfo"));


        itemsService.addItems(itemsCustom);
        request.getRequestDispatcher("/queryitemsbyname.action").forward(request,response);
    }

    //删除一组ID值
    @RequestMapping(value = "/deleteIds")
    public void deleteItemsByIds(HttpServletRequest request,
                                 HttpServletResponse response)throws Exception{
        //call by service
        String [] ids = request.getParameterValues("selItem");
        Integer [] idss = new Integer[ids.length];
        for (int i = 0 ; i < ids.length; i++) {
            idss[i] = Integer.valueOf(ids[i]);
        }
        itemsService.moveItemsByIds(idss);
        request.getRequestDispatcher("/queryitemsbyname.action").forward(request,response);
    }

    //deletebyId
    @RequestMapping(value = "/deleteByid")
    public String deleteItemsById(@RequestParam(value = "id") Integer myid)throws Exception{
        itemsService.moveItemsById(myid);
        return "redirect:queryitemsbyname.action";
    }

    //******** 批量更新 *******
    static String linkedID = null;
    static String[] strId = null;
    static Items[] items  = null;
    static int[] checkBoxIds = null;
    @RequestMapping(value = "/multis")
    public String multis(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        if(linkedID == null)
            linkedID = request.getParameter("id");

        if(linkedID == null) {
            if(strId == null)
                strId = request.getParameterValues("selItem");
            checkBoxIds = new int[strId.length];
            items = new Items[strId.length];
            for (int i = 0; i < checkBoxIds.length; i++) {
                checkBoxIds[i] = Integer.parseInt(strId[i]);
            }

            for (int i = 0; i < items.length; i++) {
                items[i] = itemsService.queryItemsById(checkBoxIds[i]);
            }
            model.addAttribute("itemsKey", items);
            return "multiEdit";
        }else {
            int linkId_int = Integer.parseInt(linkedID);
            Items items = new Items();
            items = itemsService.queryItemsById(linkId_int);
            model.addAttribute("itemsKey", items);
            return "multiEdit";
        }
    }

    //****去执行批量更新
    @RequestMapping(value = "/multisChange")
    public String multisChange(Items[] items, HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");
        String[] formId = request.getParameterValues("formId");
        int[] ints = new int[formId.length];;
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(formId[i]);
            System.out.println(">" + ints[i]);
            System.out.println(items);
        }
        for (int i = 0; i < items.length; i++) {
            itemsService.modifyItems(ints[i], items[i]);
        }
        return "redirect:queryitemsbyname.action";
    }

    @RequestMapping(value = "/batchModifyShow")
    public String batchModifyShow(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.setContentType("text/html;charset=UTF-8");

        String [] ids = request.getParameterValues("selItem");
        Integer [] idss = new Integer[ids.length];
        for (int i = 0 ; i < ids.length; i++) {
            idss[i] = Integer.valueOf(ids[i]);
        }

    }
}
