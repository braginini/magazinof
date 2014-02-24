package ru.ncideas.magazinof.gwt.util;

import org.dozer.DozerBeanMapper;
import ru.ncideas.magazinof.entity.*;
import ru.ncideas.magazinof.entity.Account;
import ru.ncideas.magazinof.gwt.client.dto.*;

import java.util.ArrayList;
import java.util.List;

public class DozerGenerator {

    /* Account <-> AccountDto */
    public static Account accountDtoToEntity(DozerBeanMapper mapper, AccountDto dto) {
        return mapper.map(dto, Account.class);
    }

    public static AccountDto accountEntityToDto(DozerBeanMapper mapper, Account account) {
        return mapper.map(account, AccountDto.class);
    }

    public static List<AccountDto> accountListEntityToDto(DozerBeanMapper mapper, List<Account> accounts) {
        List<AccountDto> models = new ArrayList<AccountDto>();
        for (Account a : accounts) {
            models.add(DozerGenerator.accountEntityToDto(mapper, a));
        }
        return models;
    }

    public static List<Account> accountListDtoToEntity(DozerBeanMapper mapper, List<AccountDto> dtos) {
        List<Account> accounts = new ArrayList<Account>();
        for (AccountDto a : dtos) {
            accounts.add(DozerGenerator.accountDtoToEntity(mapper, a));
        }
        return accounts;
    }

    /* User <-> UserDto */
    public static User appUserDtoToEntity(DozerBeanMapper mapper, UserDto dto) {
        return mapper.map(dto, User.class);
    }

    public static UserDto appUserEntityToDto(DozerBeanMapper mapper, User user) {
        return mapper.map(user, UserDto.class);
    }

    public static List<UserDto> appUserListEntityToDto(DozerBeanMapper mapper, List<User> users) {
        List<UserDto> models = new ArrayList<UserDto>();
        for (User u : users) {
            models.add(DozerGenerator.appUserEntityToDto(mapper, u));
        }
        return models;
    }

    public static List<User> appUserListDtoToEntity(DozerBeanMapper mapper, List<UserDto> dtos) {
        List<User> users = new ArrayList<User>();
        for (UserDto u : dtos) {
            users.add(DozerGenerator.appUserDtoToEntity(mapper, u));
        }
        return users;
    }

    /* Role <-> RoleDto */
    public static Role roleDtoToEntity(DozerBeanMapper mapper, RoleDto dto) {
        return mapper.map(dto, Role.class);
    }

    public static RoleDto roleEntityToDto(DozerBeanMapper mapper, Role role) {
        return mapper.map(role, RoleDto.class);
    }

    public static List<RoleDto> roleListEntityToDto(DozerBeanMapper mapper, List<Role> roles) {
        List<RoleDto> models = new ArrayList<RoleDto>();
        for (Role r : roles) {
            models.add(DozerGenerator.roleEntityToDto(mapper, r));
        }
        return models;
    }

    public static List<Role> roleListDtoToEntity(DozerBeanMapper mapper, List<RoleDto> dtos) {
        List<Role> roles = new ArrayList<Role>();
        for (RoleDto r : dtos) {
            roles.add(DozerGenerator.roleDtoToEntity(mapper, r));
        }
        return roles;
    }

    /* Function <-> FunctionDto */
    public static Function functionDtoToEntity(DozerBeanMapper mapper, FunctionDto dto) {
        return mapper.map(dto, Function.class);
    }

    public static FunctionDto functionEntityToDto(DozerBeanMapper mapper, Function function) {
        return mapper.map(function, FunctionDto.class);
    }

    public static List<FunctionDto> functionListEntityToDto(DozerBeanMapper mapper, List<Function> functions) {
        List<FunctionDto> models = new ArrayList<FunctionDto>();
        for (Function f : functions) {
            models.add(DozerGenerator.functionEntityToDto(mapper, f));
        }
        return models;
    }

    public static List<Function> functionListDtoToEntity(DozerBeanMapper mapper, List<FunctionDto> dtos) {
        List<Function> functions = new ArrayList<Function>();
        for (FunctionDto f : dtos) {
            functions.add(DozerGenerator.functionDtoToEntity(mapper, f));
        }
        return functions;
    }

    /* MenuItem <-> MenuItemDto */
    public static MenuItem menuItemDtoToEntity(DozerBeanMapper mapper, MenuItemDto dto) {
        return mapper.map(dto, MenuItem.class);
    }

    public static MenuItemDto menuItemEntityToDto(DozerBeanMapper mapper, MenuItem menuItem) {
        return mapper.map(menuItem, MenuItemDto.class);
    }

    public static List<MenuItemDto> menuItemListEntityToDto(DozerBeanMapper mapper, List<MenuItem> menuItems) {
        List<MenuItemDto> models = new ArrayList<MenuItemDto>();
        for (MenuItem m : menuItems) {
            models.add(DozerGenerator.menuItemEntityToDto(mapper, m));
        }
        return models;
    }

    public static List<MenuItem> menuItemListDtoToEntity(DozerBeanMapper mapper, List<MenuItemDto> dtos) {
        List<MenuItem> menuItems = new ArrayList<MenuItem>();
        for (MenuItemDto m : dtos) {
            menuItems.add(DozerGenerator.menuItemDtoToEntity(mapper, m));
        }
        return menuItems;
    }

    /* Organization <-> OrganizationDto */
    public static Organization organizationDtoToEntity(DozerBeanMapper mapper, OrganizationDto dto) {
        return mapper.map(dto, Organization.class);
    }

    public static OrganizationDto organizationEntityToDto(DozerBeanMapper mapper, Organization organization) {
        return mapper.map(organization, OrganizationDto.class);
    }

    public static List<OrganizationDto> organizationListEntityToDto(DozerBeanMapper mapper, List<Organization> organizations) {
        List<OrganizationDto> models = new ArrayList<OrganizationDto>();
        for (Organization m : organizations) {
            models.add(DozerGenerator.organizationEntityToDto(mapper, m));
        }
        return models;
    }

    public static List<Organization> organizationListDtoToEntity(DozerBeanMapper mapper, List<OrganizationDto> dtos) {
        List<Organization> organizations = new ArrayList<Organization>();
        for (OrganizationDto m : dtos) {
            organizations.add(DozerGenerator.organizationDtoToEntity(mapper, m));
        }
        return organizations;
    }

    /* Order <-> OrderDto */
    public static Order orderDtoToEntity(DozerBeanMapper mapper, OrderDto dto) {
        return mapper.map(dto, Order.class);
    }

    public static OrderDto orderEntityToDto(DozerBeanMapper mapper, Order entity) {
        return mapper.map(entity, OrderDto.class);
    }

    public static List<OrderDto> orderListEntityToDto(DozerBeanMapper mapper, List<Order> entities) {
        List<OrderDto> dtos = new ArrayList<OrderDto>();
        for (Order e : entities) {
            dtos.add(DozerGenerator.orderEntityToDto(mapper, e));
        }
        return dtos;
    }

    public static List<Order> orderListDtoToEntity(DozerBeanMapper mapper, List<OrderDto> dtos) {
        List<Order> entities = new ArrayList<Order>();
        for (OrderDto d : dtos) {
            entities.add(DozerGenerator.orderDtoToEntity(mapper, d));
        }
        return entities;
    }

    /* OrderStatus <-> OrderStatusDto */
    public static OrderStatus orderStatusDtoToEntity(DozerBeanMapper mapper, OrderStatusDto dto) {
        return mapper.map(dto, OrderStatus.class);
    }

    public static OrderStatusDto orderStatusEntityToDto(DozerBeanMapper mapper, OrderStatus entity) {
        return mapper.map(entity, OrderStatusDto.class);
    }

    public static List<OrderStatusDto> orderStatusListEntityToDto(DozerBeanMapper mapper, List<OrderStatus> entities) {
        List<OrderStatusDto> dtos = new ArrayList<OrderStatusDto>();
        for (OrderStatus e : entities) {
            dtos.add(DozerGenerator.orderStatusEntityToDto(mapper, e));
        }
        return dtos;
    }

    public static List<OrderStatus> orderStatusListDtoToEntity(DozerBeanMapper mapper, List<OrderStatusDto> dtos) {
        List<OrderStatus> entities = new ArrayList<OrderStatus>();
        for (OrderStatusDto d : dtos) {
            entities.add(DozerGenerator.orderStatusDtoToEntity(mapper, d));
        }
        return entities;
    }

    /* Customer <-> CustomerDto */
    public static Customer customerDtoToEntity(DozerBeanMapper mapper, CustomerDto dto) {
        return mapper.map(dto, Customer.class);
    }

    public static CustomerDto customerEntityToDto(DozerBeanMapper mapper, Customer entity) {
        return mapper.map(entity, CustomerDto.class);
    }

    public static List<CustomerDto> customerListEntityToDto(DozerBeanMapper mapper, List<Customer> entities) {
        List<CustomerDto> dtos = new ArrayList<CustomerDto>();
        for (Customer e : entities) {
            dtos.add(DozerGenerator.customerEntityToDto(mapper, e));
        }
        return dtos;
    }

    public static List<Customer> customerListDtoToEntity(DozerBeanMapper mapper, List<CustomerDto> dtos) {
        List<Customer> entities = new ArrayList<Customer>();
        for (CustomerDto d : dtos) {
            entities.add(DozerGenerator.customerDtoToEntity(mapper, d));
        }
        return entities;
    }

    /* Address <-> AddressDto */
    public static Address addressDtoToEntity(DozerBeanMapper mapper, AddressDto dto) {
        return mapper.map(dto, Address.class);
    }

    public static AddressDto addressEntityToDto(DozerBeanMapper mapper, Address entity) {
        return mapper.map(entity, AddressDto.class);
    }

    public static List<AddressDto> addressListEntityToDto(DozerBeanMapper mapper, List<Address> entities) {
        List<AddressDto> dtos = new ArrayList<AddressDto>();
        for (Address e : entities) {
            dtos.add(DozerGenerator.addressEntityToDto(mapper, e));
        }
        return dtos;
    }

    public static List<Address> addressListDtoToEntity(DozerBeanMapper mapper, List<AddressDto> dtos) {
        List<Address> entities = new ArrayList<Address>();
        for (AddressDto d : dtos) {
            entities.add(DozerGenerator.addressDtoToEntity(mapper, d));
        }
        return entities;
    }

    /* Phone <-> PhoneDto */
    public static Phone phoneDtoToEntity(DozerBeanMapper mapper, PhoneDto dto) {
        return mapper.map(dto, Phone.class);
    }

    public static PhoneDto phoneEntityToDto(DozerBeanMapper mapper, Phone entity) {
        return mapper.map(entity, PhoneDto.class);
    }

    public static List<PhoneDto> phoneListEntityToDto(DozerBeanMapper mapper, List<Phone> entities) {
        List<PhoneDto> dtos = new ArrayList<PhoneDto>();
        for (Phone e : entities) {
            dtos.add(DozerGenerator.phoneEntityToDto(mapper, e));
        }
        return dtos;
    }

    public static List<Phone> phoneListDtoToEntity(DozerBeanMapper mapper, List<PhoneDto> dtos) {
        List<Phone> entities = new ArrayList<Phone>();
        for (PhoneDto d : dtos) {
            entities.add(DozerGenerator.phoneDtoToEntity(mapper, d));
        }
        return entities;
    }

    /* DeliveryType <-> DeliveryTypeDto */
    public static DeliveryType deliveryTypeDtoToEntity(DozerBeanMapper mapper, DeliveryTypeDto dto) {
        return mapper.map(dto, DeliveryType.class);
    }

    public static DeliveryTypeDto deliveryTypeEntityToDto(DozerBeanMapper mapper, DeliveryType entity) {
        return mapper.map(entity, DeliveryTypeDto.class);
    }

    public static List<DeliveryTypeDto> deliveryTypeListEntityToDto(DozerBeanMapper mapper, List<DeliveryType> entities) {
        List<DeliveryTypeDto> dtos = new ArrayList<DeliveryTypeDto>();
        for (DeliveryType e : entities) {
            dtos.add(DozerGenerator.deliveryTypeEntityToDto(mapper, e));
        }
        return dtos;
    }

    public static List<DeliveryType> deliveryTypeListDtoToEntity(DozerBeanMapper mapper, List<DeliveryTypeDto> dtos) {
        List<DeliveryType> entities = new ArrayList<DeliveryType>();
        for (DeliveryTypeDto d : dtos) {
            entities.add(DozerGenerator.deliveryTypeDtoToEntity(mapper, d));
        }
        return entities;
    }

    /* Good <-> GoodDto */
    public static Good goodDtoToEntity(DozerBeanMapper mapper, GoodDto dto) {
        return mapper.map(dto, Good.class);
    }

    public static GoodDto goodEntityToDto(DozerBeanMapper mapper, Good entity) {
        return mapper.map(entity, GoodDto.class);
    }

    public static List<GoodDto> goodListEntityToDto(DozerBeanMapper mapper, List<Good> entities) {
        List<GoodDto> dtos = new ArrayList<GoodDto>();
        for (Good e : entities) {
            dtos.add(DozerGenerator.goodEntityToDto(mapper, e));
        }
        return dtos;
    }

    public static List<Good> goodListDtoToEntity(DozerBeanMapper mapper, List<GoodDto> dtos) {
        List<Good> entities = new ArrayList<Good>();
        for (GoodDto d : dtos) {
            entities.add(DozerGenerator.goodDtoToEntity(mapper, d));
        }
        return entities;
    }

    /* Measure <-> MeasureDto */
    public static Measure measureDtoToEntity(DozerBeanMapper mapper, MeasureDto dto) {
        return mapper.map(dto, Measure.class);
    }

    public static MeasureDto measureEntityToDto(DozerBeanMapper mapper, Measure entity) {
        return mapper.map(entity, MeasureDto.class);
    }

    public static List<MeasureDto> measureListEntityToDto(DozerBeanMapper mapper, List<Measure> entities) {
        List<MeasureDto> dtos = new ArrayList<MeasureDto>();
        for (Measure e : entities) {
            dtos.add(DozerGenerator.measureEntityToDto(mapper, e));
        }
        return dtos;
    }

    public static List<Measure> measureListDtoToEntity(DozerBeanMapper mapper, List<MeasureDto> dtos) {
        List<Measure> entities = new ArrayList<Measure>();
        for (MeasureDto d : dtos) {
            entities.add(DozerGenerator.measureDtoToEntity(mapper, d));
        }
        return entities;
    }


}
