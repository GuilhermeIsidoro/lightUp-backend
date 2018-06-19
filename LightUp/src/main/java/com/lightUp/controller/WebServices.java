package com.lightUp.controller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lightUp.Request.NewDevice;
import com.lightUp.Request.UpdateDevice;
import com.lightUp.Return.Default;
import com.lightUp.Return.GetDeviceReturn;
import com.lightUp.Util.Constants;
import com.lightUp.model.Device;
import com.lightUp.repository.Devices;

@RestController
@RequestMapping("/lightUp")
public class WebServices {
	
	final static Logger logger = Logger.getLogger(WebServices.class);
	
	@Autowired
	private Devices devicesRep;
	
	//Retorna um dispositivo especifico ou todos, de acordo com os parametros enviados.
	@RequestMapping(value = "/getDevice", method = RequestMethod.GET)
	public GetDeviceReturn getDevice(@RequestParam(value = "id", required = false) Integer id,
									 @RequestParam(value = "status", required = false) Integer status) {
		
		logger.debug("Searching devices");

		GetDeviceReturn ret = new GetDeviceReturn();
		
		try {

			if (status == null) {
				
				if (id != null && id!= 0) {
					
					ret.getDevices().add(devicesRep.findOne(id));
					
				} else if (id == null || id == 0) {
					
					ret.setDevices(devicesRep.findAll());
				}
				
			} else if (status != null) {
				
				if (id != null && id != 0) {
					
					ret.getDevices().add(devicesRep.findByIdAndStatus(id, status));
					
				} else if (id == null || id == 0) {
					
					ret.setDevices(devicesRep.findAllByStatus(status));					
				}				
			}
			
			if (ret.getDevices() == null || ret.getDevices().isEmpty()) {
				
				ret.setMessage("Dispositivo não encontrado");
				
			} else {
				
				ret.setMessage(ret.getDevices().size() + " dispositivo(s) encontrado(s)");
			}
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
			
			ret.setMessage("Ocorreu um erro");
			
		}
		
		return ret;
	}
	
	//Adiciona um novo dispositivo.
	@RequestMapping(value = "/addDevice", method = RequestMethod.POST)
	public Default addDevice(@RequestBody NewDevice add) {
		
		logger.debug("Adding new device: " + add.getName());
		
		Default ret = new Default();
		
		try {
			
			Device newDevice = new Device();
			
			newDevice.setName(add.getName());
			newDevice.setDeviceOn(Constants.DEVICE_OFF);
			newDevice.setOnTimer(0L);
			newDevice.setPeriodConsumption(0.0);
			newDevice.setTimeOfChange(new Date());
			newDevice.setDeviceConsumption(add.getDeviceConsumption());
			newDevice.setStatus(Constants.ACTIVE_DEVICE);
			
			devicesRep.save(newDevice);
			
			ret.setMessage("Novo Dispositivo cadastrado com sucesso");
			
			logger.debug("New device added: " + newDevice.getName());
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
			
			ret.setMessage("Ocoreu um erro");
			
		}
		
		return ret;
	}
	
	//Edita um dispositivo já existente.
	@RequestMapping(value = "/updateDevice", method = RequestMethod.POST)
	public Default updateDevice(@RequestBody UpdateDevice update) {
		
		logger.debug("Updating device " + update.getName());
		
		Default ret = new Default();
		
		try {
			
			Device currentDevice = devicesRep.findOne(update.getId());
			
			currentDevice.setName(update.getName());				
			currentDevice.setDeviceConsumption(update.getDeviceConsumption());
			currentDevice.setStatus(update.getStatus());
			
			devicesRep.save(currentDevice);
			
			ret.setMessage("Novo Dispositivo cadastrado com sucesso");
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
			
			ret.setMessage("Ocorreu um erro");
			
		}
		
		return ret;
	}
	
	//Liga ou desliga um dispositivo.
	@RequestMapping(value = "/onOffDevice", method = RequestMethod.POST)
	public Default onOffDevice(@RequestParam (value = "id", required = true) Integer id) {
		
		logger.debug("Swithing device " + id + " on/off");
		
		Default ret = new Default();
		
		try {
			
			if (id != 0) {
			
				Device onOffDevice = devicesRep.findByIdAndStatus(id, Constants.ACTIVE_DEVICE);
				
				if (onOffDevice != null) {
				
					Date lastChange = onOffDevice.getTimeOfChange();
					
					if (onOffDevice.getDeviceOn() == Constants.DEVICE_ON) {
						
						onOffDevice.setDeviceOn(Constants.DEVICE_OFF);
						
						Long currentTimer = onOffDevice.getOnTimer();
												
						Long onTimer = (new Date().getTime() - lastChange.getTime());
						
						onOffDevice.setOnTimer(currentTimer + onTimer);
						
						onOffDevice.setTimeOfChange(new Date());
						
						devicesRep.save(onOffDevice);
						
					} else {
						
						onOffDevice.setDeviceOn(Constants.DEVICE_ON);
						onOffDevice.setTimeOfChange(new Date());
						
						devicesRep.save(onOffDevice);
					}
					
					
				} else {
					
					ret.setMessage("Dispositivo não encontrado");
					
					return ret;
				}

				ret.setMessage("Estado alterado");
				//Teste
				//ret.setMessage("Ficou " + (onOffDevice.getOnTimer()/1000) + " ligado");
				
			} else {
				
				ret.setMessage("Id inválido informado");
				
			}
			
		} catch (Exception e) {
			
			logger.error(e.getMessage());
			
			ret.setMessage("Ocorreu um erro");
			
		}
		
		return ret;
	}	

}











